**Data Consistency in Microservices**

Saga Pattern
Reconciliation
	- Application Event Log can help to get the failed transaction to successfully complete reconciliation.

Challenges
	- Orchestration or choreography
	- Periods of inconsistency
	- Implementation complexity

Solution
	- BASE(Basic Availablity Soft-State Eventual Consistency) over ACID
	
Database native Tools
	- MongoDB Oplog
	- MySQL Changelog
	- Postgresql Changelog

CDC Challenges
	- Business logic split
	- Self-implemented vs packaged

Event Stream
	Message Brokers	(RabbitMQ or ActiveMQ)
		vs
	Message Streams	(Kafka)
		vs
	Event Databases	
	
	
https://awstip.com/asynchronous-communication-message-broker-vs-event-stream-when-to-use-what-656a8bc7b201

Your Choices

1. Consistency by design
	- Accespt inconsistency by design.
	- make operations irreversible and idempotent.
2. Change Single datasource at a time
	- Change First(CDC)
	- Event First(EDA, CQRS)
3. Sagas, compensate and reconcile
	- Orchestration
	- Choreography

**Sagas**

Create Order Saga : Break distributed transaction in set of local transactions as described in below steps.<br>
Steps:<br>
	1. CreateOrder in order service and mark order in PENDING state.<br>
	2. Complete PAYMENT on payment service.<br>
	3. Come back to order service and mark order state as APPROVED.<br>

**Complications With Saga**

1. Rollback using compensating transactions
	- Acid transactions can simply rollback.<br> 
				*BUT, In Saga* 
	- Developer must write application logic to rollback eventually consistent transaction.
	- Careful design required.<br>

	So, transaction would look like- <br>
	Every transaction (Ti) has one compensating transaction(Ci) that can rollback Ti.<br>
	Here is one scenario, <br> 
	We have two transactions T1 and T2. For them, compensating transactions are C1 and C2 respectively.<br>
	A complete distributed transaction is execution of T2 will be followed by T1.<br>
	Now, suppose T1 executed successfully but T2 got failed.<br>
	Then in this scenario, Its T2's responsibilty to rollback T1 by calling C1 on its failure.<br>
	*Here in this example,* we had only two local transactions but if one distributed transaction has 10's of local transactions then it could become more complicated.

2. Sagas Complicate API design
	- Request initiates the saga. When to send back the reponse? Means, on which point of distributed transaction, you will send back the response?<br>
	- Option #1: Send reponse when saga completes.<br>
		-> + is Response specifies the outcome. <br>
		-> - is Reduced Availability. <br>
	- Option #2 : Send response immediately after creating the saga (recommended) <br>
		-> Improved availability.<br>
		-> Response does not specify the outcome. Client must be polled or be notified. <br>

	So, API's would look like, <br>
	- createOrder() <br>
		- Returns ID of newly created Order. <br>
		- NOT fully Validated. <br>
	- getOrder(id) <br>
		- Called periodically by client to get outcome of validation.

**Saga: Minimal Impact on UI**

* UI hides asynchronous API from the user.
* Saga will usually appear instantenous.(<=100ms>)
* If it takes longer -> UI displays processing popup.
* Server can push notifaction to UI.
	
**Sagas complicate the business logic**
* Changes are committed by each steps of saga.
* Other transactions see "inconsistent" data, eg. Order.state=PENDING, more complex logic.
* Interaction between sagas and other operations.<br>
	- eg. what does it mean to cancel a PENDING order.
	- "Interrupt" the create order saga.
	- Wait for the create order saga to complete?



**Books Recommended**
1. Designing Data Intensive Application
2. Microservices Patterns

**Reference**

1. [Saga blog on Microservices.com](https://microservices.io/patterns/data/saga.html#:~:text=Example%3A%20Choreography%2Dbased%20saga&text=The%20Order%20Service%20receives%20the,an%20event%20indicating%20the%20outcome)

2. [Youtube - Using sagas to maintain data consistency in a microservice architecture by Chris Richardson](https://www.youtube.com/watch?v=YPbGW3Fnmbc) 26:29

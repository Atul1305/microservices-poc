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

Create Order Saga : Break distribution transaction in set of local transactions as described in below steps.<br>
Steps:<br>
	1. CreateOrder in order service and mark order in PENDING state.<br>
	2. Complete PAYMENT on payment service.<br>
	3. Come back to order service and mark order state as APPROVED.<br>

Complications With Saga
1. Rollback using compensating transactions
	- Acid transactions can simply rollback.<br> 
				*BUT, In Saga* 
	- Developer must write application logic to rollback eventually consistent transaction.
	- Careful design required.<br>

	So, Saga transaction would look like- <br>
	Every transaction (Ti) has one compensating transaction(Ci) that can rollback Ti.<br>
	Here is one scenario, <br> 
	We have two transactions T1 and T2. For them, compensating transactions are C1 and C2 respectively.<br>
	A complete distributed transaction is execution of T2 will be followed by T1.<br>
	Now, suppose T1 executed successfully but T2 got failed.<br>
	Then in this scenario, Its T2's responsibilty to rollback T1 by calling C1 on its failure.<br>
	*Here in this example,* we had only two local transactions but if one distributed transaction has 10's of local transactions then it could become more complicated.

2. Sagas Complicate API design

	




**Books Recommended**
1. Designing Data Intensive Application
2. Microservices Patterns

**Reference**

[Youtube - Using sagas to maintain data consistency in a microservice architecture by Chris Richardson](https://www.youtube.com/watch?v=YPbGW3Fnmbc) 22:05

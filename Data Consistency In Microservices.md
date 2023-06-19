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



**Books Recommended**
1. Designing Data Intensive Application
2. Microservices Patterns

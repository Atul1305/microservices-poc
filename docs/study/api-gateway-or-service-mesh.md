**Introduction**

In a microservice architecture, for clients to communicate with the backend, they need a service such as a service mesh or API gateway to relay these API requests.
<br>
The API gateway, however, doesn’t know by itself how to identify the particular backend service a client requests, so it forwards the request to another service: called service-discovery.

**What is a service registry?**

The service registry is a database that holds the data structures for network service instances. It serves as a messaging system that transports data for application-level communication.

**What is service discovery?**

Service discovery (otherwise known as service location discovery) is how applications and microservices can automatically locate & communicate with each other. It is a fundamental pattern in service architecture that helps track where every microservice can be found. These microservices register their details with the discovery server, making it easy to communicate.

**Types of service discovery**

    - A server-side discovery: 
    This discovery pattern permits client applications to request a service via a load balancer. The load balancer then queries the service registry before routing the client’s request.

    - A client-side discovery: 
    With the client-side discovery, the client is responsible for selecting network services available; by querying the service registry.

**What is an API gateway?**

An API gateway is a management service that accepts API requests from clients, directs the requests to the correct backend services, aggregates the results retrieved, and returns a synchronous response to the client.

**What is a service mesh?** 

A service mesh is an infrastructure layer that handles how internal services within an application communicate. It adds microservice discovery, load balancing, encryption, authentication, observability, security, and reliability features to “cloud-native” applications making them reliable and fast.


**References**

https://blog.getambassador.io/microservice-service-discovery-api-gateway-or-service-mesh-77c468167025

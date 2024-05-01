
**Why Microservices?**

In the case of monolith applications, there are several problems like

a. Same code base for presentation, business layer, and data access layer. Application is deployed as a single unit.

b. Complexity to maintain and scalability is an issue.

Microservice solves the above problems.

Microservices are ideal when a monolith or a legacy application needs to be modernized.

For new software development, if the key business drivers are to reduce time to market, scalable better software, lower costs, faster development, or cloud-native development, microservices are ideal.

Each service is independent and gives the flexibility to choose the programming language, database, and/or architecture.

Distinct services can be developed, deployed, and maintained independently.

<br>

**What is an API gateway in microservices?**

API Gateway in Microservices is a Microservices Architecture pattern.

API Gateway is a server and is a single-entry point into the system. API Gateway is responsible for routing the request, composition, and translation of the protocol. All the requests from the clients first come to the API Gateway and the API Gateway routes the request to the correct microservice.

API Gateway can also aggregate the results from the microservices back to the client. API Gateway can also translate between web protocols like HTTP, web socket, etc.

API Gateway can provide every client with a custom API as well.

An example of an API Gateway is Netflix API Gateway.

<br>

**How to deploy microservices?**

Microservices are developed and deployed quickly and in most cases automatically as part of the CI/CD pipeline. Microservices could be deployed in Virtual Machines or Containers. The virtual machines or containers can be On-premise or in the cloud as well.

There are different deployment approaches available for Microservices. Some of the possible deployment approaches for microservices are mentioned below.

Multiple service instances per host
Service instance per host
Service instance per VM
Service instance per Container
Serverless deployment
Service deployment platform

<br>

**How to handle exceptions in microservices?**

In the case of microservices, exception handling is important. If any exception/error is not handled, it will be propagated to all the downstream services creating an impact on the user experience. To make the services more resilient, handling exceptions becomes very important.

In the case of ‘500 — Internal Service Error’, Sprint Boot will respond like below.

(

“timestamp”: “2020–04–02T01:31:08.501+00:00”,

“path”: “/shop/action”,

“status”: 500,

“error”: “Internal Server Error”,

“message”: “”,

“requestId”: “a8c4c6d4–3”

}

Spring provides ControllerAdvice for exception handling in Spring Boot Microservices. @ControllerAdivce informs Spring Boot that a class will act like an Interceptor in case of any exceptions.

We can have any number of exception handlers to handle each exception.

Eg. For handling generic Exception and RunTimeException, we can have 2 exception handlers.

@ControllerAdvice

public class ApplicationExceptionHandler {

@ExceptionHandler(Exception.class)

public ResponseEntity handleGenericException(Exception e)

{

ShopException shopException = new ShopException(100, “Items are not found”);

return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR) .body(shopException);

}

@ExceptionHandler(RuntimeException.class)

public ResponseEntity handleRunTimeException(RuntimeException e)

{

ShopException shopException = new ShopException(101, “Item is not found”);

return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR) .body(shopException);

}

}

<br>

**What is Spring Cloud?**

Spring Cloud is an open-source library that provides tools for quickly deploying the JVM based application on the clouds. It provides a better user experience and an extensible mechanism due to various features like Distributed configuration, Circuit breakers, Global locks, Service registrations, Load balancing, Cluster state, Routing, Load Balancing, etc. It is capable of working with spring and different applications in various languages

Features of Spring Cloud

Major features are as below:

Distributed configuration
Distributed messaging
service-to-service calls
Circuit breakers
Global locks
Service registration
Service Discovery
Load balancing
Cluster state
Routing

<br>

**How Do You Override A Spring Boot Project’s Default Properties?**

Spring Application loads properties from the application.properties files in the following locations and add them to the Spring Environment:

A /config subdirectory of the current directory.
The current directory
A classpath /config package
The classpath root

<br>

**How Is Spring Security Implemented In A Spring Boot Application?**

Spring Security is a framework that majorly focuses on providing both authentication and authorization to Java EE-based enterprise software applications.

Adding Spring security:

Maven:

To include spring security, include the below dependency:

<dependencies>

<dependency>

<groupID>org.springframework.security</groupID>

<artifactId>spring-security-config</artifactID>

<version>5.5.0</version>

</dependency>

<dependency>

<groupId>org.springframework.security</groupId>

<artifactId>spring-security-web</artifactId>

<version>5.5.0</version>

</dependency>

</dependencies>

<br>

**What is Hystrix and how can it be implemented in the Spring Boot Application?**

Netflix’s Hystrix is a library that provides an implementation of the Circuit Breaker pattern for Microservices based applications. A circuit breaker is a pattern that monitors for failures and once the failures reach a certain threshold, the circuit breaker trips, and all further calls will return with an error, without the external call being made at all.

On applying a Hystrix circuit breaker to a method, it watches for failing calls to that method, and if failures build up to a threshold; Hystrix opens the circuit so that subsequent calls automatically fail.

While the circuit is open, Hystrix redirects to a specified method called a fallback method. This creates a time buffer for the related service to recover from its failing state.

Below are the annotations used to enable Hystrix in a Spring Boot application:

@EnableCircuitBreaker: It is added to the main Application class for enabling Hystrix as a circuit breaker and to enable hystrix-javanica; which is a wrapper around native Hystrix required for using the annotations.

@HystrixCommand: This is method annotation that notifies Spring to wrap a particular method in a proxy connected to a circuit breaker so that Hystrix can monitor it. We also need to define a fallback method having the backup logic that needs to be executed in the failure scenario. Hystrix passes the control to this fallback method when the circuit is broken.

This annotation can also be used for asynchronous requests. Currently, it works only with classes marked with @Component or @Service.
<br>

**What is Service Discovery and how can it be enabled in Spring Boot?**

In a typical Microservice architecture multiple services collaborate to provide an overall functionality. These set of service instances may have dynamically assigned network locations. Also, the services scale up and down as per the load. It could get tricky in a cloud environment resolving the services that are required for operation for common functionality.

Consequently, in order for a client to make a request to a service, it must use a service-discovery mechanism. It is the process where services register with a central registry and other services query this registry for resolving dependencies.

A service registry is a highly available and up to date database containing the network locations of service instances. The two main service-discovery components are client-side discovery and service-side discovery.

Netflix Eureka is one of the popular Service Discovery Server and Client tools. Spring Cloud supports several annotations for enabling service discovery. @EnableDiscoveryClient annotation allows the applications to query the Discovery server to find required services.

In Kubernetes environments, service discovery is built-in, and it performs service instance registration and deregistration.

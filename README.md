# Microservices

Microservice architecture is combination of multiple service that talk to each other. 

# Microservices Orchestration

Microservices orchestration is the process of managing and coordinating the interactions between multiple microservices to achieve a specific business goal.

# Circuit Breaker Pattern

The circuit breaker pattern allows you to build a fault tolerant and resilient system that can survive gracefully when key services are either unavailable or have high latency.
-> Solution <br>
    * It cache the response and return cached response at the time of service on which it depends on goes down. <br>
    * It also let the another service to cool off by returning response from cached memory. We can set cool off time for other service, suppose 5 mins. <br>
    * We can return response by calling to similar service in some cases. <br>


    
# Service Mesh
Service Mesh is one more component which actually runs along with every micro-service deployment and helps to do all following things. <br>
* Load balancing (service level)
* Service Discovery
* Metrics
* Retries
* Circuit Breaking
* Timeout
This is implemeted using side-car pattern. It also implements proxy design pattern. Service-Mesh contains following two components. <br>
-> Control Plane - All configuration regarding service-mesh is controlled by this, we also call it control tower. <br>
-> Data Plane - Side-car in all microservices. <br>

# Deployment Pattern
* Scalability and throughput <br>
   -> Multiple services per VM <br>
   -> Service per VM/Container <br>
   -> Serverless <br>
* Reliable and available
* Isolation
* Resource limit
* Monitor
* Cost-effective


# Reference
* [microservices.io](https://microservices.io/)
* [Design Patterns](https://blog.bitsrc.io/my-favorite-microservice-design-patterns-for-node-js-fe048c635d83)
* [Circuit Breaker Pattern - Youtube](https://www.youtube.com/watch?v=5XeVoHtFGo0)
* [What is Circuit Breaker Design Pattern in Microservices? Spring Cloud Netflix Hystrix Example in Java?](https://medium.com/javarevisited/what-is-circuit-breaker-design-pattern-in-microservices-java-spring-cloud-netflix-hystrix-example-f285929d7f68)
* [Debugging challenges : Distributed tracing is the answer.](https://thenewstack.io/tracing-why-logs-arent-enough-to-debug-your-microservices/)
* [Microservices Orchestration](https://blog.getambassador.io/microservice-orchestration-best-practices-f32314dd6a12)
* [50 Microservices Interview Questions](https://medium.com/javarevisited/50-microservices-interview-questions-for-java-programmers-70a4a68c4349)

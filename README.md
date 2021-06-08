# microservices-poc
It is repository built for learning purpose. 

# Circuit Breaker Pattern <br>
The circuit breaker pattern allows you to build a fault tolerant and resilient system that can survive gracefully when key services are either unavailable or have high latency.
-> Solution <br>
    * It cache the response and return cached response at the time of service on which it depends on goes down. <br>
    * It also let the another service to cool off by returning response from cached memory. We can set cool off time for other service, suppose 5 mins. <br>
    * We can return response by calling to similar service in some cases. <br>


# Reference
* Doc -> https://microservices.io/
* Design Patterns -> https://blog.bitsrc.io/my-favorite-microservice-design-patterns-for-node-js-fe048c635d83
* Circuit Breaker Pattern -> https://www.youtube.com/watch?v=5XeVoHtFGo0

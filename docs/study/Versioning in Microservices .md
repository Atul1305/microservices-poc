**What is Versioning and Why is it Important?**

Assume that you have a service that is up and running in the production environment and there are multiple consumers of it as well. Now suppose you need to add more functionality to the service to suffice customer’s requirements.

Since there are several users of the old service, you might want to keep the existing functionality intact. So, you might have some users who need the old service while there are other users who will need a version with new or extended features. Here’s exactly where API versioning comes to the rescue.

**Microservices Versioning Strategies**

Two of the most common ways of versioning APIs for microservices-based applications are:
* Versioning in the URI
* Versioning in the Header
* Semantic Versioning - Major.Minor.Patch

**Challenges of Versioning**

 Maintaining too many versions of your API might be a nightmare for you in the long run, you can deprecate older versions of your API and/or rerouting the traffic to the newer versions of the API.

**Reference**

[Best Practices in Microservices Versioning](https://www.codeguru.com/dotnet/best-practices-versioning-microservices/)
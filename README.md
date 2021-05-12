# Phonebook Directory

This is a REST Web-Service responsible for maintaining a database of mobile
numbers. By default, it has been configured to expose the endpoints globally
to deal with CORS (this is for `testing` purposes ONLY and must be discouraged!)
and its associated challenges.

<b>NB:</b> Once the calling endpoints are decided upon, they will replace the 
global config.

## Tech Stack
The following are the tech stack used for implementation
- MySQL: This was used for data persistence.
- Project Lombok: we generated all our POJOs boilerpate code with Lombok.
Also, other relevant methods like constructors were generated on the fly with 
  annotations like `@Data`.
- JPA: we took advantage of Spring `JPA`'s `CRUD` repository's implementation to 
cater for basic SQL operations.
- [Swagger](#swagger): the RESTful API documentation was developed using Swagger 
- SLF4J: for logging


## Endpoints
Below is a brief description of some of the endpoints;
kindly visit `http://localhost:8080/api/v1/swagger-ui.html for a thorough
description of all the endpoints.

`GET` /api/v1/owners - retrieves all subscriber owners.

`GET` /api/v1/owners/search/findByMsisdnContaining - returns all mobile numbers
that match a certain criteria.

`POST` /api/v1/owners - adds a mobile subscriber ti the database.

`PATCH` /api/v1/owners/{id} - change a mobile number plan from prepaid to postpaid
or vice versa
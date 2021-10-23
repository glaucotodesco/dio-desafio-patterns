# dio-desafio-patterns

This sample has 3 projets: Server1, Server2 and Facade.

Server1 has a endpoint: GET Mono<Model> (localhost:8080/model)
Server2 has a endpoint: GET Mono<Info>  (localhost:8081/info)
The facade project is a client of Server1 and Server2 and  is used as a Facade: GET Mono<FacadeData> (localhost/facade)

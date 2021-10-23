package com.example.facade.client;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import reactor.core.publisher.Mono;


@Service
public class Client {
  
    private final WebClient modelClient;
    private final WebClient infoClient;
    
    public Client(WebClient.Builder builder) {
      this.modelClient = builder.baseUrl("http://localhost:8080").build();
      this.infoClient  = builder.baseUrl("http://localhost:8081").build();
    }
  
    public Mono<Model> getModel() {
      
     Mono<Model> model = this.modelClient
                .get()
                .uri("/model").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Model.class)
                .next();
                
                

      return model;          
    }

    public Mono<Info> getInfo() {
      
      Mono<Info> info = this.infoClient
                 .get()
                 .uri("/info").accept(MediaType.APPLICATION_JSON)
                 .retrieve()
                 .bodyToFlux(Info.class)
                 .next();
       return info;          
     }

}

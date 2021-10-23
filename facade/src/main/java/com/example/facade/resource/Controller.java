package com.example.facade.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

import com.example.facade.client.*;
import com.example.facade.model.FacadeData;

@RestController
@RequestMapping("/facade")
public class Controller {

    @Autowired
    private Client client;

    @GetMapping
    public Mono<FacadeData> getModel() {

          final Mono<Model> model = client.getModel();
          final Mono<Info>  info  = client.getInfo();

          final Mono<FacadeData> facade =  model.map(FacadeData::new)
                                                .zipWith(info)
                                                .map( t -> {
                                                    t.getT1().setInfo(t.getT2());
                                                    return t.getT1();
                                                });
      
                                
                
          return facade;
    }

}

package com.example.server2.handler;

import java.util.Random;


import com.example.server2.model.Info;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class MyHandler {

    public Mono<ServerResponse> getModelData(ServerRequest request) {

        Info data = Info.builder()
                        .value(new Random().nextInt(10)+1000)
                        .description(RandomStringUtils.randomAlphanumeric(20))
                        .build();

        return ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(data));
      }

}

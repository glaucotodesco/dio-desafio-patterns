package com.example.server1.handler;

import java.util.Random;
import com.example.server1.model.Model;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class MyHandler {

    public Mono<ServerResponse> getModel(ServerRequest request) {

        Model model = Model.builder()
                        .number(new Random().nextInt(10))
                        .text(RandomStringUtils.randomAlphanumeric(10))
                        .build();

        return ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(model));
      }

}

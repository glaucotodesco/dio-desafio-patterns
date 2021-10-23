package com.example.server1.router;

import com.example.server1.handler.MyHandler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class MyRouter {

    @Bean
    public RouterFunction<ServerResponse> route(MyHandler handler) {

        return RouterFunctions
                .route(
                      GET("/model")
                            .and(accept(MediaType.APPLICATION_JSON))
                    , handler::getModel
                );
    }

}

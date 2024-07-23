package com.gateway.filter.global.function;

import com.fasterxml.jackson.databind.JsonNode;
import com.util.Result;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.factory.rewrite.RewriteFunction;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.LinkedHashMap;

@Component
public class ResponseBodyRewrite implements RewriteFunction<Object, Result> {

    @Override
    public Publisher<Result> apply(ServerWebExchange serverWebExchange, Object responseBody) {
        if (responseBody instanceof LinkedHashMap<?,?> map) {

        }
        return Mono.just(Result.success(responseBody));
    }

}
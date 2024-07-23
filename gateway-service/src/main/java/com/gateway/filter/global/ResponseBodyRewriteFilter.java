package com.gateway.filter.global;

import com.fasterxml.jackson.databind.JsonNode;
import com.gateway.filter.global.function.ResponseBodyRewrite;
import com.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.NettyWriteResponseFilter;
import org.springframework.cloud.gateway.filter.factory.rewrite.ModifyResponseBodyGatewayFilterFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class ResponseBodyRewriteFilter implements GlobalFilter, Ordered {

    @Autowired
    ModifyResponseBodyGatewayFilterFactory modifyResponseBodyFactory;

    @Autowired
    ResponseBodyRewrite responseBodyRewrite;

    @Override
    public int getOrder() {
        return NettyWriteResponseFilter.WRITE_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return modifyResponseBodyFactory
                .apply(new ModifyResponseBodyGatewayFilterFactory.Config()
                        .setRewriteFunction(Object.class, Result.class, responseBodyRewrite))
                .filter(exchange, chain);
    }

}
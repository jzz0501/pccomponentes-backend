package com.gateway.filter.global;

import com.util.JWT;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

//@Component
public class TokenAuthGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();

        if(request.getPath().toString().contains("/api/auth")) {
            chain.filter(exchange);
        }

        HttpHeaders headers = request.getHeaders();

        List<String> token = headers.get("token");
        if(token != null && !token.isEmpty()) {
            JWT.parseJwt(token.get(0));
        }

        return chain.filter(exchange);

    }

    @Override
    public int getOrder() {
        return -1;
    }

}

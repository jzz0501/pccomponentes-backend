package com.pedido;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EntityScan(value = "com.data.pedido")
@EnableDiscoveryClient
@SpringBootApplication
public class PedidoAPI {
    public static void main(String[] args) {
        SpringApplication.run(PedidoAPI.class, args);
    }
}
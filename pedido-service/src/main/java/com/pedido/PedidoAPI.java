package com.pedido;

import com.api.BasketAPI;
import com.api.ClientAPI;
import com.api.ProductAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EntityScan(value = "com.data.pedido")
@EnableFeignClients(clients = {ProductAPI.class, ClientAPI.class, BasketAPI.class})
@EnableDiscoveryClient
@SpringBootApplication
public class PedidoAPI {
    public static void main(String[] args) {
        SpringApplication.run(PedidoAPI.class, args);
    }
}
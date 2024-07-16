package com.basket;

import com.api.ClientAPI;
import com.api.ProductAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EntityScan(value = "com.data.basket")
@EnableFeignClients(clients = {ClientAPI.class, ProductAPI.class})
@EnableDiscoveryClient
@SpringBootApplication
public class BasketAPI {
    public static void main(String[] args) {
        SpringApplication.run(BasketAPI.class, args);
    }
}
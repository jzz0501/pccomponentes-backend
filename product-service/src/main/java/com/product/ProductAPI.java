package com.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EntityScan(value = "com.data.product")
@EnableDiscoveryClient
@SpringBootApplication
public class ProductAPI {
    public static void main(String[] args) {
        SpringApplication.run(ProductAPI.class, args);
    }
}
package com.opinion;

import com.api.ClientAPI;
import com.api.ProductAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EntityScan(value = "com.data.opinion")
@EnableFeignClients(clients = {ClientAPI.class, ProductAPI.class})
@EnableDiscoveryClient
@SpringBootApplication
public class OpinionAPI {
    public static void main(String[] args) {
        SpringApplication.run(OpinionAPI.class, args);
    }
}
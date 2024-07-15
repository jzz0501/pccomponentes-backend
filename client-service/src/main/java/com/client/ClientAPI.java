package com.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EntityScan(value = "com.data.client")
@EnableDiscoveryClient
@SpringBootApplication
public class ClientAPI {
    public static void main(String[] args) {
        SpringApplication.run(ClientAPI.class, args);
    }
}
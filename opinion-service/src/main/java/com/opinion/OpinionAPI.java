package com.opinion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EntityScan(value = "com.data.opinion")
@EnableDiscoveryClient
@SpringBootApplication
public class OpinionAPI {
    public static void main(String[] args) {
        SpringApplication.run(OpinionAPI.class, args);
    }
}
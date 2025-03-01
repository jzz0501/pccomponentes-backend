package com.auth;

import com.api.ClientAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients(clients = {ClientAPI.class})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AuthAPI {
    public static void main(String[] args) {
        SpringApplication.run(AuthAPI.class, args);
    }
}
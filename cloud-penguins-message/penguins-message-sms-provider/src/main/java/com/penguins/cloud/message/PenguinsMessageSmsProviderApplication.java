package com.penguins.cloud.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableConfigurationProperties
public class PenguinsMessageSmsProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PenguinsMessageSmsProviderApplication.class, args);
    }

}

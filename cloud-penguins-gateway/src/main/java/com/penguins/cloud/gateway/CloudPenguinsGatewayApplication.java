package com.penguins.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudPenguinsGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudPenguinsGatewayApplication.class, args);
  }
}

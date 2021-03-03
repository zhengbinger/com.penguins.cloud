package com.penguins.cloud.cloudpenguinsauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@MapperScan({"com.penguins.cloud.cloudpenguinsauth.repository"})
@SpringBootApplication
@EnableDiscoveryClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CloudPenguinsAuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudPenguinsAuthApplication.class, args);
  }
}

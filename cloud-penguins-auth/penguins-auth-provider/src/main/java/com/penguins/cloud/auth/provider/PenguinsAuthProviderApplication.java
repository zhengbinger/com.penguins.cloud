package com.penguins.cloud.auth.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/** @author zhengbing */
@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
@EnableFeignClients(basePackages = {"com.penguins.cloud.auth.client.service"})
public class PenguinsAuthProviderApplication {

  public static void main(String[] args) {
    SpringApplication.run(PenguinsAuthProviderApplication.class, args);
  }
}

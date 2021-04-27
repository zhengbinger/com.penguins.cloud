package com.penguins.cloud.cloudpenguinsauth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/** @author zhengbing */
@MapperScan({"com.penguins.cloud.repository"})
@SpringBootApplication
@EnableDiscoveryClient
public class CloudPenguinsAuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudPenguinsAuthApplication.class, args);
  }
}

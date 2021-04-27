package com.penguins.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 网关服务主启动类
 *
 * @author zhengbing
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudPenguinsGatewayApplication {

  public static void main(String[] args) {

    SpringApplication.run(CloudPenguinsGatewayApplication.class, args);
  }
}

package com.penguins.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 用户服务
 *
 * @author zhengbing
 * @date 2021/4/24 00:44
 * @email mydreambing@126.com
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PenguinsUserProviderApplication {

  public static void main(String[] args) {
    SpringApplication.run(PenguinsUserProviderApplication.class, args);
  }
}

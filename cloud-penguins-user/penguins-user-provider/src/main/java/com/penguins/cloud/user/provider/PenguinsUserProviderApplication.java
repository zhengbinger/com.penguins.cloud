package com.penguins.cloud.user.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhengbing
 * @date 2021/4/25 12:26
 * @email mydreambing@126.com
 */
@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"springfox.documentation.swagger2", "com.penguins"})
@EnableFeignClients(
        basePackages = {"com.penguins.cloud.user.client.service", "com.penguins.cloud.commons"})
public class PenguinsUserProviderApplication {
  public static void main(String[] args) {
    SpringApplication.run(PenguinsUserProviderApplication.class, args);
  }
}

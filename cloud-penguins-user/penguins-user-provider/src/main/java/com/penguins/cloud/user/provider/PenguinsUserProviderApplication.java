package com.penguins.cloud.user.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.function.Consumer;

/**
 * 用户服务
 *
 * @author zhengbing
 * @date 2021/4/25 12:26
 * @email mydreambing@126.com
 */

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = {"springfox.documentation.swagger2", "com.penguins"})
@EnableFeignClients(
        basePackages = {"com.penguins.cloud.user.client.service", "com.penguins.cloud.commons"})
public class PenguinsUserProviderApplication {
  public static void main(String[] args) {
    SpringApplication.run(PenguinsUserProviderApplication.class, args);
    
  }


  /**
   * 注册加密器
   *
   * @return
   */
  @Bean
  public PasswordEncoder bcrypt() {
    return new BCryptPasswordEncoder();
  }

  private Logger log = LoggerFactory.getLogger(PenguinsUserProviderApplication.class);

  @Bean
  public Consumer<String> penguins() {
    return message -> {
      log.info("接收的普通消息为：{}", message);
    };
  }
}

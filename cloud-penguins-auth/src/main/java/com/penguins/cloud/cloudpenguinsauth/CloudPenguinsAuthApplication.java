package com.penguins.cloud.cloudpenguinsauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhengbing
 */
//@MapperScan({"com.penguins.cloud.cloudpenguinsauth.repository"})
@SpringBootApplication
@EnableDiscoveryClient
//@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CloudPenguinsAuthApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudPenguinsAuthApplication.class, args);
  }

}

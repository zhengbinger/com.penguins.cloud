package com.penguins.cloud.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhengbing
 * @date 2021/1/25
 * @email mydreambing@126.com
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudPenguinsWorkflowApplication {

  public static void main(String[] args) {
      SpringApplication.run(CloudPenguinsWorkflowApplication.class,args);
  }
}

package com.penguins.cloud.files;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 文件服务主启动类
 *
 * @author zhengbing
 * @date 2021/1/27 15:02
 * @email mydreambing@126.com
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudPenguinsFilesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudPenguinsFilesApplication.class, args);
    }
}

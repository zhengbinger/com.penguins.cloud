package com.penguins.cloud.files.provider.controller;

import com.aliyun.oss.OSS;
import com.penguins.cloud.files.provider.file.client.AliyunOssClient;
import com.penguins.cloud.files.provider.file.client.OssClientFactory;
import com.penguins.cloud.files.provider.file.client.OssConfigurationProperties;
import com.penguins.cloud.web.RspResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Client Controller
 *
 * @author 郑冰
 * @date 2022/1/19 20:51
 * @email mydreambing@126.com
 * @since jdk8
 **/
@RestController
@RequestMapping("oss/client")
@Api(tags = "Client")
public class ClientController {

    @Autowired
    private OssConfigurationProperties ossConfigurationProperties;

    @GetMapping
    @ApiOperation("获取客户端")
    public RspResult getClient() {
        try {
            AliyunOssClient aliyunOssClient = OssClientFactory.getClient(AliyunOssClient.class);
            OSS client = aliyunOssClient.getClient(ossConfigurationProperties);
            System.out.println(client);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return RspResult.success();
    }
}

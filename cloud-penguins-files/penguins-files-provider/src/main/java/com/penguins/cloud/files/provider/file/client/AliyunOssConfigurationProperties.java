package com.penguins.cloud.files.provider.file.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Aliyun 配置属性类
 *
 * @author 郑冰
 * @date 2022/1/19 17:15
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Component
@ConfigurationProperties(prefix = "penguins.oss.aliyun")
public class AliyunOssConfigurationProperties implements OssConfigurationProperties {

    private String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";

    private String accessKeyId;

    private String accessSecret;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public AliyunOssConfigurationProperties setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public AliyunOssConfigurationProperties setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public AliyunOssConfigurationProperties setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
        return this;
    }
}

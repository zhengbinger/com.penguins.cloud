package com.penguins.cloud.files.provider.file.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 郑冰
 * @date 2022/1/19 17:15
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Component
@ConfigurationProperties(prefix = "penguins.oss.aliyun")
public class AliyunClientProperties {

    private String accessKeyId;

    private String accessSecret;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public AliyunClientProperties setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public AliyunClientProperties setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
        return this;
    }
}

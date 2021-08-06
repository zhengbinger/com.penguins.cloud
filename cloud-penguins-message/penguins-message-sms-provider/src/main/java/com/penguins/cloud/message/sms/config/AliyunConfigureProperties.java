package com.penguins.cloud.message.sms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 郑冰
 * @date 2021/8/6 17:04
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Component
@ConfigurationProperties(prefix = "aliyun.sms")
public class AliyunConfigureProperties {

    private String accessKeyId;
    private String accessKeySecret;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public AliyunConfigureProperties setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public AliyunConfigureProperties setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
        return this;
    }
}

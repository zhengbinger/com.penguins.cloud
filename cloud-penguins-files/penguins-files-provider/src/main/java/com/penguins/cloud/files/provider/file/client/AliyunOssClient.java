package com.penguins.cloud.files.provider.file.client;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

/**
 * Aliyun 客户端
 *
 * @author 郑冰
 * @date 2022/1/19 17:09
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class AliyunOssClient implements OssClient<OSS> {

    @Override
    public OSS getClient(OssConfigurationProperties ossConfigurationProperties) {
        AliyunOssConfigurationProperties aliyunConfigProperties = (AliyunOssConfigurationProperties) ossConfigurationProperties;
        return new OSSClientBuilder().build(aliyunConfigProperties.getEndpoint(), aliyunConfigProperties.getAccessKeyId(), aliyunConfigProperties.getAccessSecret());
    }
}

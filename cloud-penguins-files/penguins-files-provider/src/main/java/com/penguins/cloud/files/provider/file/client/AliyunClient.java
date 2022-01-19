package com.penguins.cloud.files.provider.file.client;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

/**
 * @author 郑冰
 * @date 2022/1/19 17:09
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class AliyunClient implements OssClient {


    @Override
    public OssClient getClient() {

        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = "yourEndpoint";

        // 从STS服务获取的临时访问密钥（AccessKey ID和AccessKey Secret）。
        String accessKeyId = "yourAccessKeyId";
        String accessKeySecret = "yourAccessKeySecret";
        // 从STS服务获取的安全令牌（SecurityToken）。
        String securityToken = "yourSecurityToken";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret, securityToken);

        // 关闭OSSClient。
        ossClient.shutdown();
        return null;
    }
}

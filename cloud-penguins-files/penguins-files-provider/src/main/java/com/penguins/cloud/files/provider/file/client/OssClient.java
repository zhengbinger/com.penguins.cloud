package com.penguins.cloud.files.provider.file.client;

/**
 * OssClient 通用接口
 *
 * @author 郑冰
 * @date 2022/1/19 17:13
 * @email mydreambing@126.com
 * @since jdk8
 **/
public interface OssClient {

    /**
     * 获取Client 实例
     *
     * @return
     */
    OssClient getClient();
}

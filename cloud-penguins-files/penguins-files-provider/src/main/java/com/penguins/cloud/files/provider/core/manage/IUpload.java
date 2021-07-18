package com.penguins.cloud.files.provider.core.manage;

import java.io.InputStream;

/**
 * 文件上传接口
 *
 * @author 郑冰
 * @date 2021/7/18 14:54
 * @email mydreambing@126.com
 * @since jdk8
 **/
public interface IUpload {

    /**
     * 文件上传
     *
     * @param inputStream InputStream
     * @return 文件路径
     */
    String upload(InputStream inputStream);
}

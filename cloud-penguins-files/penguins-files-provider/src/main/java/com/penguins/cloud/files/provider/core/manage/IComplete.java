package com.penguins.cloud.files.provider.core.manage;

/**
 * 文件处理完成接口
 *
 * @author 郑冰
 * @date 2021/7/18 15:02
 * @email mydreambing@126.com
 * @since jdk8
 **/
public interface IComplete {

    /**
     * 上传完成后处理
     */
    void uploadComplete();

    /**
     * 下载完成后处理
     */
    void downloadComplete();

    /**
     * 读取完成后处理
     */
    void readComplete();

    /**
     * 写入完成后处理
     */
    void writeComplete();
}

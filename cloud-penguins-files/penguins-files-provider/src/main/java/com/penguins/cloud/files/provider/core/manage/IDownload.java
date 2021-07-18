package com.penguins.cloud.files.provider.core.manage;

import java.io.OutputStream;

/**
 * 文件下载接口
 *
 * @author 郑冰
 * @date 2021/7/18 14:54
 * @email mydreambing@126.com
 * @since jdk8
 **/
public interface IDownload {

    /**
     * 文件下载
     *
     * @return OutputStream 输出流
     */
    OutputStream download();
}

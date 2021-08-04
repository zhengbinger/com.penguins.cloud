package com.penguins.cloud.user.provider.service;

/**
 * 发送短消息业务类
 *
 * @author 郑冰
 * @date 2021/8/4 15:32
 * @email mydreambing@126.com
 * @since jdk8
 **/
public interface ISmsService {

    /**
     * 发送短消息
     *
     * @param message 　短消息
     */
    void sendSms(String message);
}

package com.penguins.cloud.message.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

/**
 * @author 郑冰
 * @date 2021/8/4 15:50
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Service
public class SmsConsumerService {

    private Logger log = LoggerFactory.getLogger(SmsConsumerService.class);

    /**
     * 函数式编辑接收消息
     *
     * @return
     */
    @Bean
    public Consumer<String> sms() {
        return message -> {
            log.info("接收的普通消息为：{}", message);
        };
    }
}

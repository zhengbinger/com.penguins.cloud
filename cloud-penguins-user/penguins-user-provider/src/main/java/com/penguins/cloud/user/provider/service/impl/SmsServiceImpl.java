package com.penguins.cloud.user.provider.service.impl;

import com.penguins.cloud.user.provider.config.StreamContants;
import com.penguins.cloud.user.provider.service.ISmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

/**
 * @author 郑冰
 * @date 2021/8/4 15:31
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Service
public class SmsServiceImpl implements ISmsService {

    @Autowired
    private final StreamBridge streamBridge;

    public SmsServiceImpl(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @Override
    public void sendSms(String message) {
        streamBridge.send(StreamContants.SMS_MESSAGE_OUTPUT, message);
    }
}

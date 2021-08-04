package com.penguins.cloud.user.provider.config;

import com.baomidou.mybatisplus.core.toolkit.StringPool;

/**
 * @author 郑冰
 * @date 2021/8/4 11:44
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class StreamContants {
    /**
     * 生产者服务名称
     */
    public static final String MESSAGE_PRODUCER_SERVICE = "penguins-message-producer";

    /**
     * 消费者服务名称
     */
    public static final String MESSAGE_CONSUMER_SERVICE = "penguins-message-consumer";

    /**
     * 生产者标识
     */
    public static final String OUTPUT = "out" + StringPool.DASH + StringPool.ZERO;

    /**
     * 消费者标识
     */
    public static final String INPUT = "in" + StringPool.DASH + StringPool.ZERO;

    /**
     * 短信消息
     */
    public static final String SMS_MESSAGE = "sms" + StringPool.DASH;

    /**
     * 邮件消息
     */
    public static final String EMAIL_MESSAGE = "email" + StringPool.DASH;

    /**
     * 消息生产者
     */
    public static final String SMS_MESSAGE_OUTPUT = SMS_MESSAGE + OUTPUT;

    /**
     * 邮件生产者
     */
    public static final String EMAIL_MESSAGE_OUTPUT = EMAIL_MESSAGE + OUTPUT;

    /**
     * 短信消费者
     */
    public static final String SMS_MESSAGE_INPUT = SMS_MESSAGE + INPUT;

    /**
     * 邮件消费者
     */
    public static final String EMAIL_MESSAGE_INPUT = EMAIL_MESSAGE + INPUT;
}

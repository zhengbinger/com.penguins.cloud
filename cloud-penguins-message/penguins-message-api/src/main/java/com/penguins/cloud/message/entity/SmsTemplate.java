package com.penguins.cloud.message.entity;

import com.penguins.cloud.base.BaseEntityCreator;

import java.io.Serializable;

/**
 * @author 郑冰
 * @date 2021/8/6 17:40
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class SmsTemplate extends BaseEntityCreator implements Serializable {

    private static final long serialVersionUID = -7078954024881905956L;
    private long id;
    private String code;
    private String name;
    private boolean status;
    private String platform;

    public long getId() {
        return id;
    }

    public SmsTemplate setId(long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public SmsTemplate setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public SmsTemplate setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isStatus() {
        return status;
    }

    public SmsTemplate setStatus(boolean status) {
        this.status = status;
        return this;
    }
}

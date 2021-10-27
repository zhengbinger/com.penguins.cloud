package com.penguins.cloud.base;

/**
 * @author 郑冰
 * @date 2021/8/6 17:46
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class BaseEntityStatus implements BaseEntity {

    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public BaseEntity setStatus(boolean status) {
        this.status = status;
        return this;
    }
}

package com.penguins.cloud.commons.base;

import java.io.Serializable;

/**
 * @author 郑冰
 * @date 2021/8/6 17:43
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class BaseEntityId implements BaseEntity {

    private Serializable id;

    public Serializable getId() {
        return id;
    }

    public BaseEntity setId(Serializable id) {
        this.id = id;
        return this;
    }
}

package com.penguins.cloud.user.api.entity;

import java.io.Serializable;

/**
 * @author 郑冰
 * @date 2021/7/30 20:51
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class UserContact implements Serializable {
    private static final long serialVersionUID = -7783873721765199825L;

    private long id;
    private String mobile;
    private String tel;
    private String email;

    public long getId() {
        return id;
    }

    public UserContact setId(long id) {
        this.id = id;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public UserContact setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public UserContact setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserContact setEmail(String email) {
        this.email = email;
        return this;
    }
}

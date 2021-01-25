package com.penguins.cloud.cloudpenguinsauth.entity;

/**
 * 用户基本信息
 * @author zhengbing
 * @date 2021/1/20
 * @email mydreambing@126.com
 */
public class UserInfo {

    private long id;
    private String username;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

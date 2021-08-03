package com.penguins.cloud.user.api.entity;

import java.io.Serializable;

/**
 * @author zhengbing
 * @date 2021/4/25 15:57
 * @email mydreambing@126.com
 */
public class User implements Serializable {

  private static final long serialVersionUID = -503878178490519694L;

  long id;
  String username;
  String realname;
  String password;
  String mobile;
  String email;

  public User() {
  }

  public User(String username, String realname, String password, String mobile, String email) {
    this.username = username;
    this.realname = realname;
    this.password = password;
    this.mobile = mobile;
    this.email = email;
  }

  public long getId() {
    return id;
  }

  public User setId(long id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public User setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getRealname() {
    return realname;
  }

  public User setRealname(String realname) {
    this.realname = realname;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public User setPassword(String password) {
    this.password = password;
    return this;
  }

  public String getMobile() {
    return mobile;
  }

  public User setMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }
}

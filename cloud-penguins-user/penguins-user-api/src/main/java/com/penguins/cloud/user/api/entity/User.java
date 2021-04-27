package com.penguins.cloud.user.api.entity;

/**
 * @author zhengbing
 * @date 2021/4/25 15:57
 * @email mydreambing@126.com
 */
public class User {

  long id;
  String username;
  String realname;
  String password;

  public User() {}

  public User(String username, String realname, String password) {
    this.username = username;
    this.realname = realname;
    this.password = password;
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
}

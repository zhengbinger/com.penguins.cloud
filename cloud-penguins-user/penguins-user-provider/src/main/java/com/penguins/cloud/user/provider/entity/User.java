package com.penguins.cloud.user.provider.entity;

/**
 * @author zhengbing
 * @date 2021/4/25 15:57
 * @email mydreambing@126.com
 */
public class User {

  private long id;
  private String username;
  private String realname;

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
}

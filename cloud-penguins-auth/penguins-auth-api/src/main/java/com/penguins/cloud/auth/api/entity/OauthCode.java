package com.penguins.cloud.auth.api.entity;

import java.io.Serializable;

/**
 * (OauthCode)实体类
 *
 * @author makejava
 * @since 2021-04-29 09:28:09
 */
public class OauthCode implements Serializable {
  private static final long serialVersionUID = 154981951882158444L;

  private String code;

  private Object authentication;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Object getAuthentication() {
    return authentication;
  }

  public void setAuthentication(Object authentication) {
    this.authentication = authentication;
  }
}

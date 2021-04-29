package com.penguins.cloud.auth.api.entity;

import java.io.Serializable;

/**
 * (OauthRefreshToken)实体类
 *
 * @author makejava
 * @since 2021-04-29 09:28:09
 */
public class OauthRefreshToken implements Serializable {
  private static final long serialVersionUID = -49433594543748616L;

  private String tokenId;

  private Object token;

  private Object authentication;

  public String getTokenId() {
    return tokenId;
  }

  public void setTokenId(String tokenId) {
    this.tokenId = tokenId;
  }

  public Object getToken() {
    return token;
  }

  public void setToken(Object token) {
    this.token = token;
  }

  public Object getAuthentication() {
    return authentication;
  }

  public void setAuthentication(Object authentication) {
    this.authentication = authentication;
  }
}

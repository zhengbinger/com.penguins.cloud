package com.penguins.cloud.auth.api.entity;

import java.io.Serializable;

/**
 * (OauthClientToken)实体类
 *
 * @author makejava
 * @since 2021-04-29 09:28:09
 */
public class OauthClientToken implements Serializable {
  private static final long serialVersionUID = 246974180997200909L;

  private String tokenId;

  private Object token;

  private String authenticationId;

  private String userName;

  private String clientId;

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

  public String getAuthenticationId() {
    return authenticationId;
  }

  public void setAuthenticationId(String authenticationId) {
    this.authenticationId = authenticationId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }
}

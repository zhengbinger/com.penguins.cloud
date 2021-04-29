package com.penguins.cloud.auth.api.entity;

import java.io.Serializable;

/**
 * (OauthAccessToken)实体类
 *
 * @author makejava
 * @since 2021-04-29 09:27:44
 */
public class OauthAccessToken implements Serializable {

  private static final long serialVersionUID = 167438641275896684L;

  private String tokenId;

  private Object token;

  private String authenticationId;

  private String userName;

  private String clientId;

  private Object authentication;

  private String refreshToken;

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

  public Object getAuthentication() {
    return authentication;
  }

  public void setAuthentication(Object authentication) {
    this.authentication = authentication;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }
}

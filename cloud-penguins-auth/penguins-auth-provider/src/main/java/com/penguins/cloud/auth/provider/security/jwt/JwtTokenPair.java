package com.penguins.cloud.auth.provider.security.jwt;

import java.io.Serializable;

/**
 * @author zhengbing
 * @date 2021/3/26 16:01
 * @email mydreambing@126.com
 */
public class JwtTokenPair implements Serializable {
  private static final long serialVersionUID = 6007303192556772507L;
  private String accessToken;
  private String refreshToken;

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }
}

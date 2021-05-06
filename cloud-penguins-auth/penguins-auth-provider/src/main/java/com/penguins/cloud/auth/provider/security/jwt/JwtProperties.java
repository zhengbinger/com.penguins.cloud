package com.penguins.cloud.auth.provider.security.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhengbing
 * @date 2021/3/26 15:58
 * @email mydreambing@126.com
 */
@ConfigurationProperties(prefix = JwtProperties.JWT_PREFIX)
public class JwtProperties {
  static final String JWT_PREFIX = "jwt.com.penguins.cloud.files.provider.config";
  /** 是否可用 */
  private boolean enabled;
  /** jks 路径 */
  private String keyLocation;
  /** key alias */
  private String keyAlias;
  /** key store pass */
  private String keyPass;
  /** jwt签发者 */
  private String iss;
  /** jwt所面向的用户 */
  private String sub;
  /** access jwt token 有效天数 */
  private int accessExpDays;
  /** refresh jwt token 有效天数 */
  private int refreshExpDays;

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public String getKeyLocation() {
    return keyLocation;
  }

  public void setKeyLocation(String keyLocation) {
    this.keyLocation = keyLocation;
  }

  public String getKeyAlias() {
    return keyAlias;
  }

  public void setKeyAlias(String keyAlias) {
    this.keyAlias = keyAlias;
  }

  public String getKeyPass() {
    return keyPass;
  }

  public void setKeyPass(String keyPass) {
    this.keyPass = keyPass;
  }

  public String getIss() {
    return iss;
  }

  public void setIss(String iss) {
    this.iss = iss;
  }

  public String getSub() {
    return sub;
  }

  public void setSub(String sub) {
    this.sub = sub;
  }

  public int getAccessExpDays() {
    return accessExpDays;
  }

  public void setAccessExpDays(int accessExpDays) {
    this.accessExpDays = accessExpDays;
  }

  public int getRefreshExpDays() {
    return refreshExpDays;
  }

  public void setRefreshExpDays(int refreshExpDays) {
    this.refreshExpDays = refreshExpDays;
  }
}

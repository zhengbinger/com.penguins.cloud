package com.penguins.cloud.auth.api.entity;

import java.io.Serializable;

/**
 * (Clientdetails)实体类
 *
 * @author makejava
 * @since 2021-04-29 09:33:09
 */
public class Clientdetails implements Serializable {
  private static final long serialVersionUID = -93840087570166823L;

  private String appid;

  private String resourceids;

  private String appsecret;

  private String scope;

  private String granttypes;

  private String redirecturl;

  private String authorities;

  private Integer accessTokenValidity;

  private Integer refreshTokenValidity;

  private String additionalinformation;

  private String autoapprovescopes;

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getResourceids() {
    return resourceids;
  }

  public void setResourceids(String resourceids) {
    this.resourceids = resourceids;
  }

  public String getAppsecret() {
    return appsecret;
  }

  public void setAppsecret(String appsecret) {
    this.appsecret = appsecret;
  }

  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

  public String getGranttypes() {
    return granttypes;
  }

  public void setGranttypes(String granttypes) {
    this.granttypes = granttypes;
  }

  public String getRedirecturl() {
    return redirecturl;
  }

  public void setRedirecturl(String redirecturl) {
    this.redirecturl = redirecturl;
  }

  public String getAuthorities() {
    return authorities;
  }

  public void setAuthorities(String authorities) {
    this.authorities = authorities;
  }

  public Integer getAccessTokenValidity() {
    return accessTokenValidity;
  }

  public void setAccessTokenValidity(Integer accessTokenValidity) {
    this.accessTokenValidity = accessTokenValidity;
  }

  public Integer getRefreshTokenValidity() {
    return refreshTokenValidity;
  }

  public void setRefreshTokenValidity(Integer refreshTokenValidity) {
    this.refreshTokenValidity = refreshTokenValidity;
  }

  public String getAdditionalinformation() {
    return additionalinformation;
  }

  public void setAdditionalinformation(String additionalinformation) {
    this.additionalinformation = additionalinformation;
  }

  public String getAutoapprovescopes() {
    return autoapprovescopes;
  }

  public void setAutoapprovescopes(String autoapprovescopes) {
    this.autoapprovescopes = autoapprovescopes;
  }
}

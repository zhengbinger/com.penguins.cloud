package com.penguins.cloud.auth.provider.security;

import com.alibaba.nacos.common.utils.JacksonUtils;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author zhengbing
 * @date 2021/3/29 09:42
 * @email mydreambing@126.com
 */
public class JwtPayloadBuilder {
  private Map<String, String> payload = new HashMap<>();

  /** 附加的属性 */
  private Map<String, String> additional;

  /** 签发者 */
  private String iss;
  /** 面向的用户 */
  private String sub;

  /** 接收 jwt 的一方 */
  private String aud;

  /** jwt 的过期时间，这个时间一定要大于签发时间 */
  private LocalDateTime exp;

  /** 签发时间，当前时间 */
  private LocalDateTime iat = LocalDateTime.now();
  /** 权限集 */
  private Set<String> roles = new HashSet<>();

  /** jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击 */
  private String jti = UUID.randomUUID().toString();

  public JwtPayloadBuilder iss(String iss) {
    this.iss = iss;
    return this;
  }

  public JwtPayloadBuilder sub(String sub) {
    this.sub = sub;
    return this;
  }

  public JwtPayloadBuilder aud(String aud) {
    this.aud = aud;
    return this;
  }

  public JwtPayloadBuilder roles(Set<String> roles) {
    this.roles = roles;
    return this;
  }

  public JwtPayloadBuilder expDays(int days) {
    Assert.isTrue(days > 0, "jwt expireDate must after now");
    this.exp = this.iat.plusDays(days);
    return this;
  }

  public JwtPayloadBuilder additional(Map<String, String> additional) {
    this.additional = additional;
    return this;
  }

  public String builder() {
    payload.put("iss", this.iss);
    payload.put("sub", this.sub);
    payload.put("aud", this.aud);
    payload.put("exp", this.exp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    payload.put("iat", this.iat.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    payload.put("jti", this.jti);

    if (!CollectionUtils.isEmpty(additional)) {
      payload.putAll(additional);
    }
    payload.put("roles", JacksonUtils.toJson(roles));
    return JacksonUtils.toJson(payload);
  }
}

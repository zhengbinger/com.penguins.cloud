package com.penguins.cloud.auth.provider.security.token;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * 短信验证码认证 Token
 *
 * @author zhengbing
 * @date 2021/4/30 10:30
 * @email mydreambing@126.com
 */
public class SmsCodeAuthenticationToken extends AbstractAuthenticationToken {

  private static final long serialVersionUID = 703742266262712339L;
  /** 身份 */
  private final Object principal;

  public SmsCodeAuthenticationToken(Object mobile) {
    super(null);
    this.principal = mobile;
    setAuthenticated(false);
  }

  public SmsCodeAuthenticationToken(
      Object principal, Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    this.principal = principal;
    // must use super, as we override
    super.setAuthenticated(true);
  }

  @Override
  public Object getPrincipal() {
    return this.principal;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    if (isAuthenticated) {
      throw new IllegalArgumentException(
          "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
    }

    super.setAuthenticated(false);
  }

  @Override
  public void eraseCredentials() {
    super.eraseCredentials();
  }

  @Override
  public Object getCredentials() {
    return null;
  }
}

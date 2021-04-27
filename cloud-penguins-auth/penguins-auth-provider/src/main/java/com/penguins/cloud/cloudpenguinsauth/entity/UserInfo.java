package com.penguins.cloud.cloudpenguinsauth.entity;

import com.penguins.cloud.user.api.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * 用户基本信息
 *
 * @author zhengbing
 * @date 2021/1/20
 * @email mydreambing@126.com
 */
public class UserInfo extends User implements UserDetails {

  private static final long serialVersionUID = 5313558419117914869L;
  private Set<RoleInfo> roleInfos;

  public Set<RoleInfo> getRoles() {
    return roleInfos;
  }

  public UserInfo setRoles(Set<RoleInfo> roleInfos) {
    this.roleInfos = roleInfos;
    return this;
  }

  public UserInfo() {}

  public UserInfo(String username, String password, Set<RoleInfo> roleInfos) {
    super(username, "", password);
    this.roleInfos = roleInfos;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }
}

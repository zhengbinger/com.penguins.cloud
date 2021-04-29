package com.penguins.cloud.auth.provider.entity;

import com.penguins.cloud.user.api.entity.Role;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

/**
 * @author zhengbing
 * @date 2021/3/3 11:23
 * @email mydreambing@126.com
 */
public class RoleInfo extends Role implements GrantedAuthority {

  private static final long serialVersionUID = 7274925333004707041L;

  @Override
  public String getAuthority() {
    return super.getRole_code();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoleInfo roleInfo = (RoleInfo) o;
    return this.getId() == roleInfo.getId()
        && Objects.equals(this.getRole_code(), roleInfo.getRole_code())
        && Objects.equals(this.getRole_code(), roleInfo.getRole_name());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.getId(), this.getRole_code(), this.getRole_name());
  }
}

package com.penguins.cloud.cloudpenguinsauth.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

/**
 * @author zhengbing
 * @date 2021/3/3 11:23
 * @email mydreambing@126.com
 */
public class Role implements GrantedAuthority {

    private static final long serialVersionUID = 7274925333004707041L;
    private long id;
    private String role_code;
    private String role_name;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole_code() {
        return role_code;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public String getAuthority() {
        return this.role_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        return id == role.id && Objects.equals(role_code, role.role_code) && Objects.equals(role_name, role.role_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role_code, role_name);
    }
}

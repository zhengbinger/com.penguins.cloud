package com.penguins.cloud.cloudpenguinsauth.entity;

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
public class UserInfo implements UserDetails {

    private static final long serialVersionUID = 8587384110671427811L;

    private long id;
    private String username;
    private String password;
    private Set<Role> roles;

    public UserInfo() {
    }

    public UserInfo(String username, String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPassword() {
        return password;
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

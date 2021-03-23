package com.penguins.cloud.cloudpenguinsauth.config;

import com.penguins.cloud.cloudpenguinsauth.entity.Role;
import com.penguins.cloud.cloudpenguinsauth.entity.UserInfo;
import com.penguins.cloud.cloudpenguinsauth.service.RoleService;
import com.penguins.cloud.cloudpenguinsauth.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * 用户认证业务逻辑
 *
 * @author zhengbing
 * @date 2021/3/23 17:03
 * @email mydreambing@126.com
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final Log log = LogFactory.getLog(UserDetailsServiceImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleServices;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("load username is:" + username);
        UserInfo userInfo = userService.getUserInfoByUsername(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("user " + username + "is not found");
        }
        Role role = roleServices.getById(userService.getRoleIdByUserName(username));

        return new UserInfo(username, userInfo.getPassword(), Collections.singleton(role));
    }
}

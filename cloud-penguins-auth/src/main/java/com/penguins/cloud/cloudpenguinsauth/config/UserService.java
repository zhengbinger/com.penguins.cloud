//package com.penguins.cloud.cloudpenguinsauth.config;
//
//import com.penguins.cloud.cloudpenguinsauth.entity.Role;
//import com.penguins.cloud.cloudpenguinsauth.entity.UserInfo;
//import com.penguins.cloud.cloudpenguinsauth.service.RoleService;
//import com.penguins.cloud.cloudpenguinsauth.service.UserInfoService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.Collections;
//
///**
// * 用户服务
// *
// * @author zhengbing
// * @date 2021/1/20
// * @email mydreambing@126.com
// */
//
//@Component
//public class UserService implements UserDetailsService {
//
//    private final Logger log = LoggerFactory.getLogger(getClass());
//
//    @Autowired
//    private UserInfoService userInfoService;
//
//    @Autowired
//    private RoleService roleService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        log.info("load username is:" + username);
//        UserInfo userInfo = userInfoService.getUserInfoByUsername(username);
//        if (userInfo == null) {
//            throw new UsernameNotFoundException("user " + username + "is not found");
//        }
//        Role role = roleService.getById(userInfoService.getRoleIdByUserName(username));
//
//        return new org.springframework.security.core.userdetails.User(
//                username, userInfo.getPassword(), Collections.singleton(role));
//    }
//}

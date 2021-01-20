package com.penguins.cloud.cloudpenguinsauth.service;

import com.penguins.cloud.cloudpenguinsauth.entity.UserInfo;

/**
 * @author zhengbing
 * @date 2021/1/20
 * @email mydreambing@126.com
 */
public interface UserInfoService {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return UserInfo
     */
     UserInfo getUserInfoByUsername(String username) ;
}

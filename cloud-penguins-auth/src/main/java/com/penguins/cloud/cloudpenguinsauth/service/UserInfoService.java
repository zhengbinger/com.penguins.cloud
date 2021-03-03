package com.penguins.cloud.cloudpenguinsauth.service;

import com.penguins.cloud.cloudpenguinsauth.entity.UserInfo;

/**
 * 用户服务接口
 *
 * @author zhengbing
 * @date 2021/1/20
 * @email mydreambing@126.com
 */
public interface UserInfoService {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return UserInfo
     */
    UserInfo getUserInfoByUsername(String username);

    /**
     * 根据用户名查询角色ID
     *
     * @param username 用户名
     * @return long 角色ID
     */
    long getRoleIdByUserName(String username);
}

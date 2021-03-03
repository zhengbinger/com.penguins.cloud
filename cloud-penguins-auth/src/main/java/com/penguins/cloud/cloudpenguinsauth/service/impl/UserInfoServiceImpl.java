package com.penguins.cloud.cloudpenguinsauth.service.impl;

import com.penguins.cloud.cloudpenguinsauth.entity.UserInfo;
import com.penguins.cloud.cloudpenguinsauth.repository.UserInfoMapper;
import com.penguins.cloud.cloudpenguinsauth.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户基本信息服务接口实现
 * 
 * @author zhengbing
 * @date 2021/1/20
 * @email mydreambing@126.com
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfoByUsername(String username) {
        return userInfoMapper.getUserByUsername(username);
    }

    @Override
    public long getRoleIdByUserName(String username) {
        return userInfoMapper.getRoleIdByUserName(username);
    }
}

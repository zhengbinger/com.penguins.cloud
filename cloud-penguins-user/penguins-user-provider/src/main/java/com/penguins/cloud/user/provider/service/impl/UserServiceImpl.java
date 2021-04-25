package com.penguins.cloud.user.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.penguins.cloud.user.provider.entity.User;
import com.penguins.cloud.user.provider.mapper.UserMapper;
import com.penguins.cloud.user.provider.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author zhengbing
 * @date 2021/4/25 16:05
 * @email mydreambing@126.com
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {}

package com.penguins.cloud.user.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.penguins.cloud.user.api.entity.User;
import com.penguins.cloud.user.provider.mapper.UserRepository;
import com.penguins.cloud.user.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务接口实现
 *
 * @author zhengbing
 * @date 2021/4/25 16:05
 * @email mydreambing@126.com
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserRepository, User> implements UserService {
  @Autowired private UserRepository userRepository;

  @Override
  public User getUserByUsername(String username) {
    return userRepository.getUserByUsername(username);
  }

  @Override
  public long getRoleIdByUserName(String username) {
    return userRepository.getRoleIdByUserName(username);
  }
}

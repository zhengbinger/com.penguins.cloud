package com.penguins.cloud.user.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.penguins.cloud.user.api.dto.UserDto;
import com.penguins.cloud.user.api.entity.User;
import com.penguins.cloud.user.provider.mapper.UserRepository;
import com.penguins.cloud.user.provider.service.ISmsService;
import com.penguins.cloud.user.provider.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ISmsService smsService;

  @Override
  public boolean saveUser(UserDto userDto) {
    User user = new User();
    BeanUtils.copyProperties(userDto, user);
    // 用户基本信息
    boolean saved = save(user);
    // 用户联系信息
    if (saved) {
      // 发送短信
      smsService.sendSms(user.getUsername());
      // 发送邮件
    }
    return saved;
  }

  @Override
  @Cacheable(cacheNames = {"username::roleid"})
  public long getRoleIdByUserName(String username) {
    return userRepository.getRoleIdByUserName(username);
  }

  @Override
  @Cacheable(cacheNames = {"username"})
  public User getUserByUsername(String username) {
    return userRepository.getUserByUsername(username);
  }

}

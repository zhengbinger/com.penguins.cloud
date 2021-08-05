package com.penguins.cloud.user.provider.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.penguins.cloud.user.api.dto.UserDto;
import com.penguins.cloud.user.api.entity.User;

/**
 * 用户服务接口
 *
 * @author zhengbing
 * @date 2021/4/25 16:03
 * @email mydreambing@126.com
 */
public interface UserService extends IService<User> {

  /**
   * 根据用户名查询用户信息
   *
   * @param username 用户名
   * @return UserInfo
   */
  User getUserByUsername(String username);

  /**
   * 根据用户名查询角色ID
   *
   * @param username 用户名
   * @return long 角色ID
   */
  long getRoleIdByUserName(String username);

  /**
   * 保存/新增用户
   *
   * @param userDto
   * @return
   */
  boolean saveUser(UserDto userDto);
}

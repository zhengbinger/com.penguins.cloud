package com.penguins.cloud.user.provider.controller;

import com.penguins.cloud.commons.web.RspResult;
import com.penguins.cloud.user.api.dto.UserDto;
import com.penguins.cloud.user.api.entity.User;
import com.penguins.cloud.user.client.service.FileRecordService;
import com.penguins.cloud.user.provider.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * @author zhengbing
 * @date 2021/4/25 16:07
 * @email mydreambing@126.com
 */
@RestController
public class UserController {

  @Autowired private UserService userService;

  @Autowired private FileRecordService fileRecordService;

  @Autowired private PasswordEncoder passwordEncoder;

  @GetMapping("user/get")
  public RspResult<User> get() {
    System.out.println(fileRecordService.get());
    return RspResult.success(userService.getById(1));
  }

  @PostMapping("user/add")
  public RspResult<User> addition(@NotNull UserDto userDto) {
    // 处理 DTO 中需要特殊处理的数据
    // 转换 DTO 数据为实体类对象数据
    User user = new User();
    BeanUtils.copyProperties(userDto, user);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    // 保存或更新用户数据
    boolean saved = userService.saveOrUpdate(user);
    if (saved) {
      return RspResult.success(user);
    }
    return RspResult.fail("保存用户失败");
  }

  @GetMapping("user/{username}")
  public RspResult<User> loadByUsername(@PathVariable String username) {
    return RspResult.success(userService.getUserByUsername(username));
  }

  @GetMapping("user/roleId/{username}")
  public RspResult<Long> getRoleIdByUsername(@PathVariable String username) {
    return RspResult.success(userService.getRoleIdByUserName(username));
  }
}

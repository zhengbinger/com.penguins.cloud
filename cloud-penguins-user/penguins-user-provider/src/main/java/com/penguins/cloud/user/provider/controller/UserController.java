package com.penguins.cloud.user.provider.controller;

import com.penguins.cloud.commons.web.RspResult;
import com.penguins.cloud.user.api.entity.User;
import com.penguins.cloud.user.client.service.FileRecordService;
import com.penguins.cloud.user.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengbing
 * @date 2021/4/25 16:07
 * @email mydreambing@126.com
 */
@RestController
public class UserController {

  @Autowired private UserService userService;

  @Autowired private FileRecordService fileRecordService;

  @GetMapping("user/get")
  public RspResult<User> get() {
    System.out.println(fileRecordService.get());
    return RspResult.success(userService.getById(1));
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

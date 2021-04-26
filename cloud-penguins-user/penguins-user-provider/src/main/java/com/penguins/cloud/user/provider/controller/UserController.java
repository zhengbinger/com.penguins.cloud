package com.penguins.cloud.user.provider.controller;

import com.penguins.cloud.user.api.entity.User;
import com.penguins.cloud.user.client.service.FileRecordService;
import com.penguins.cloud.user.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
  public User get() {
    System.out.println(fileRecordService.get());
    return userService.getById(1);
  }
}

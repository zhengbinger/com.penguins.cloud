package com.penguins.cloud.user.provider.controller;

import com.penguins.cloud.commons.web.RspResult;
import com.penguins.cloud.user.api.dto.UserDto;
import com.penguins.cloud.user.api.entity.User;
import com.penguins.cloud.user.provider.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhengbing
 * @date 2021/4/25 16:07
 * @email mydreambing@126.com
 */
@Api(tags = "用户管理接口")
@RestController
@RequestMapping("user")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private PasswordEncoder passwordEncoder;

  //  @GetMapping("{id}")
  //  public RspResult<User> get() {
  //    System.out.println(fileRecordService.get());
  //    return RspResult.success(userService.getById(1));
  //  }

  @ApiOperation("添加用户")
  @PostMapping("add")
  public RspResult<User> addition(@RequestBody UserDto userDto) {
    // 处理 DTO 中需要特殊处理的数据
    // 转换 DTO 数据为实体类对象数据
    userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
    // 保存或更新用户数据
    boolean saved = userService.saveUser(userDto);
    if (saved) {
      return RspResult.success(userDto);
    }
    return RspResult.fail("保存用户失败");
  }

  @ApiOperation("根据用户名获取用户")
  @GetMapping("{username}")
  public RspResult<User> loadByUsername(@PathVariable String username) {
    return RspResult.success(userService.getUserByUsername(username));
  }

  @ApiOperation("根据用户名获取角色ID")
  @GetMapping("roleId/{username}")
  public RspResult<Long> getRoleIdByUsername(@PathVariable String username) {
    return RspResult.success(userService.getRoleIdByUserName(username));
  }
}

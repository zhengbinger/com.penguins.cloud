package com.penguins.cloud.user.provider.controller;

import com.penguins.cloud.commons.web.RspResult;
import com.penguins.cloud.user.api.entity.Permission;
import com.penguins.cloud.user.provider.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Permission Controller
 *
 * @author zhengbing
 * @date 2021/4/29 17:33
 * @email mydreambing@126.com
 */
@RestController
@RequestMapping("permissions")
public class PermissionController {

  @Autowired
  private PermissionService permissionService;

  @GetMapping("{id}")
  public RspResult<Permission> getRoleById(@PathVariable long id) {
    return RspResult.success(permissionService.getById(id));
  }

  /**
   * 根据用户名，获取用户所有
   *
   * @param username String 用户名
   * @return RspResult<Collection < Permission>>
   */
  @GetMapping("username/{username}")
  public RspResult<Collection<Permission>> getPermissionsByUsername(@PathVariable String username) {
    return RspResult.success(permissionService.getPermissionsByUsername(username));
  }

}

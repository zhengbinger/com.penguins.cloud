package com.penguins.cloud.user.provider.controller;

import com.penguins.cloud.commons.web.RspResult;
import com.penguins.cloud.user.api.entity.Permission;
import com.penguins.cloud.user.provider.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Permission
 *
 * @author zhengbing
 * @date 2021/4/29 17:33
 * @email mydreambing@126.com
 */
@RestController
@RequestMapping("permission")
public class PermissionController {

  @Autowired private PermissionService permissionService;

  @GetMapping("{id}")
  public RspResult<Permission> getRoleById(@PathVariable long id) {
    return RspResult.success(permissionService.getById(id));
  }
}

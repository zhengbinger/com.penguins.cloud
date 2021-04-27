package com.penguins.cloud.user.provider.controller;

import com.penguins.cloud.commons.web.RspResult;
import com.penguins.cloud.user.api.entity.Role;
import com.penguins.cloud.user.provider.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengbing
 * @date 2021/4/27 17:03
 * @email mydreambing@126.com
 */
@RestController
@RequestMapping("user/role")
public class RoleController {

  @Autowired private RoleService roleService;

  @GetMapping("{id}")
  public RspResult<Role> getRoleById(@PathVariable long id) {
    return RspResult.success(roleService.getById(id));
  }
}

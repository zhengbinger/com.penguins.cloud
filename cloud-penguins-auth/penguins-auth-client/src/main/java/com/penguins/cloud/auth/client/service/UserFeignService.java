package com.penguins.cloud.auth.client.service;

import com.penguins.cloud.commons.web.RspResult;
import com.penguins.cloud.user.api.entity.Role;
import com.penguins.cloud.user.api.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhengbing
 * @date 2021/4/27 15:06
 * @email mydreambing@126.com
 */
@FeignClient(name = "penguins-user-provider")
public interface UserFeignService {

  @GetMapping("user/{username}")
  RspResult<User> loadByUsername(@PathVariable String username);

  @GetMapping("user/roleId/{username}")
  RspResult<Long> getRoleIdByUsername(@PathVariable String username);

  @GetMapping("user/role/{id}")
  RspResult<Role> getRoleById(@PathVariable long id);
}

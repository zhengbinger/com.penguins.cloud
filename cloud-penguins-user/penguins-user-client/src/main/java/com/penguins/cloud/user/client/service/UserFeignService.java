package com.penguins.cloud.user.client.service;

import com.penguins.cloud.commons.web.RspResult;
import com.penguins.cloud.user.api.entity.User;
import com.penguins.cloud.user.client.config.UserProviderFallBackConfig;
import com.penguins.cloud.user.client.service.impl.UserFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户模块远程调用接口
 *
 * @author zhengbing
 * @date 2021/4/27 15:06
 * @email mydreambing@126.com
 */
@FeignClient(name = "penguins-user-provider",
        contextId = "penguins",
        fallback = UserFeignServiceImpl.class,
        configuration = UserProviderFallBackConfig.class)
public interface UserFeignService {

  @GetMapping("user/{username}")
  RspResult<User> loadByUsername(@PathVariable String username);

  @GetMapping("user/roleId/{username}")
  RspResult<Long> getRoleIdByUsername(@PathVariable String username);
}

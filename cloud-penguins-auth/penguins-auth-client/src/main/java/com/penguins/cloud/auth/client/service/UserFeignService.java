package com.penguins.cloud.auth.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhengbing
 * @date 2021/4/27 15:06
 * @email mydreambing@126.com
 */
@FeignClient(name = "penguins-user-provider")
public interface UserFeignService {

  @GetMapping("/user/name")
  void loadByName(String name);
}

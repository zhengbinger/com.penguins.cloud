package com.penguins.cloud.user.client.service;

import com.penguins.cloud.commons.web.RspResult;
import com.penguins.cloud.user.api.entity.Role;
import com.penguins.cloud.user.client.config.UserProviderFallBackConfig;
import com.penguins.cloud.user.client.service.impl.RoleFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 郑冰
 * @date 2021/7/21 15:46
 * @email mydreambing@126.com
 * @since jdk8
 **/
@FeignClient(name = "penguins-user-provider",
        contextId = "penguins-role",
        fallback = RoleFeignServiceImpl.class,
        configuration = UserProviderFallBackConfig.class)
public interface RoleFeignService {

    @GetMapping("user/role/{id}")
    RspResult<Role> getRoleById(@PathVariable long id);
}

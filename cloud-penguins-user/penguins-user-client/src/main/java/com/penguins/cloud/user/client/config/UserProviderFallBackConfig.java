package com.penguins.cloud.user.client.config;

import com.penguins.cloud.user.client.service.impl.RoleFeignServiceImpl;
import com.penguins.cloud.user.client.service.impl.UserFeignServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 郑冰
 * @date 2021/7/21 15:47
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Configuration
public class UserProviderFallBackConfig {

    @Bean
    public UserFeignServiceImpl userService() {
        return new UserFeignServiceImpl();
    }

    @Bean
    public RoleFeignServiceImpl roleService() {
        return new RoleFeignServiceImpl();
    }
}

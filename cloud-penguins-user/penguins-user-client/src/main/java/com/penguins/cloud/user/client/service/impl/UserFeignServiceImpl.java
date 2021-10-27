package com.penguins.cloud.user.client.service.impl;

import com.penguins.cloud.web.RspResult;
import com.penguins.cloud.user.api.entity.User;
import com.penguins.cloud.user.client.service.UserFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author 郑冰
 * @date 2021/7/21 15:48
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Component
public class UserFeignServiceImpl implements UserFeignService {

    private Logger log = LoggerFactory.getLogger(UserFeignServiceImpl.class);

    @Override
    public RspResult<User> loadByUsername(String username) {
        log.error("sorry,user feign fallback code:{}", username);
        return null;
    }

    @Override
    public RspResult<Long> getRoleIdByUsername(String username) {
        return null;
    }
}

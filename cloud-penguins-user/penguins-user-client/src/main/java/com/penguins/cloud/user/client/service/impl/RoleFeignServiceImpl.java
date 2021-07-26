package com.penguins.cloud.user.client.service.impl;

import com.penguins.cloud.commons.web.RspResult;
import com.penguins.cloud.user.api.entity.Role;
import com.penguins.cloud.user.client.service.RoleFeignService;
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
public class RoleFeignServiceImpl implements RoleFeignService {

    private final Logger log = LoggerFactory.getLogger(RoleFeignServiceImpl.class);

    @Override
    public RspResult<Role> getRoleById(long roleId) {
        log.error("sorry,role feign fallback code:{}", roleId);
        return null;
    }
}

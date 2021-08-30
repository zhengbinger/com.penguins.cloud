package com.penguins.cloud.user.provider.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.penguins.cloud.commons.exception.PenguinsException;
import com.penguins.cloud.commons.utils.UUID;
import com.penguins.cloud.user.provider.service.RedisService;
import com.penguins.cloud.user.provider.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 郑冰
 * @date 2021/8/26 18:10
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private RedisService redisService;

    @Override
    public String createToken() {
        StringBuilder sb = new StringBuilder("AUTO_IDEMPOTENT_REDIS_");
        sb.append(UUID.uuid32());
        redisService.setEx(sb.toString(), sb.toString(), 10000L);
        return sb.toString();
    }

    @Override
    public boolean checkToken(HttpServletRequest request) throws Exception {

        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
            // parameter中也不存在token
            if (StringUtils.isEmpty(token)) {
                throw new PenguinsException("token获取失败", 100);
            }
        }
        if (!redisService.exists(token)) {
            throw new PenguinsException("token获取失败", 100);
        }

        boolean remove = redisService.remove(token);
        if (!remove) {
            throw new PenguinsException("token获取失败", 100);
        }
        return true;
    }
}

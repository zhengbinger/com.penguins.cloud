package com.penguins.cloud.user.provider.service.impl;

import com.penguins.cloud.user.provider.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 郑冰
 * @date 2021/8/26 17:29
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 写入
     *
     * @param key   key
     * @param value value
     * @return boolean
     */
    @Override
    public boolean set(final String key, Object value) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
        return true;
    }

    /**
     * 写入缓存设置时效时间
     *
     * @param key   key
     * @param value value
     * @return boolean
     */
    @Override
    public boolean setEx(final String key, Object value, long timeout) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        return true;
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    @Override
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取数据
     *
     * @param key key
     * @return Object
     */
    @Override
    public Object get(final String key) {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }

    /**
     * 删除数据
     *
     * @param key key
     * @return boolean
     */
    @Override
    public boolean remove(final String key) {
        return redisTemplate.delete(key);
    }
}

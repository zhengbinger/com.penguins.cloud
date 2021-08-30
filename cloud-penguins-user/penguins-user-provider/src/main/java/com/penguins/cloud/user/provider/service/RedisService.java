package com.penguins.cloud.user.provider.service;

/**
 * @author 郑冰
 * @date 2021/8/26 17:29
 * @email mydreambing@126.com
 * @since jdk8
 **/
public interface RedisService {

    /**
     * 写入
     *
     * @param key   key
     * @param value value
     * @return boolean
     */
    boolean set(final String key, Object value);

    /**
     * 写入缓存设置时效时间
     *
     * @param key   key
     * @param value value
     * @return boolean
     */
    boolean setEx(final String key, Object value, long timeout);

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    boolean exists(final String key);

    /**
     * 读取数据
     *
     * @param key key
     * @return Object
     */
    Object get(final String key);

    /**
     * 删除数据
     *
     * @param key key
     * @return boolean
     */
    boolean remove(final String key);


}

package com.penguins.cloud.commons.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis 缓存模板，缓存管理器配置
 *
 * @author zhengbing
 * @date 2021/5/8 16:54
 * @email mydreambing@126.com
 */
@EnableCaching
@Configuration
public class RedisConfig {

  @Bean
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(factory);

    GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();

    // 值采用json序列化
    redisTemplate.setValueSerializer(serializer);
    // 使用StringRedisSerializer来序列化和反序列化redis的key值
    redisTemplate.setKeySerializer(new StringRedisSerializer());

    // 设置hash key 和value序列化模式
    redisTemplate.setHashKeySerializer(new StringRedisSerializer());
    redisTemplate.setHashValueSerializer(serializer);
    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }

  @Bean
  public RedisCacheManager redisCacheManager(RedisTemplate<String, Object> redisTemplate) {
    RedisCacheWriter redisCacheWriter =
        RedisCacheWriter.nonLockingRedisCacheWriter(redisTemplate.getConnectionFactory());
    RedisCacheConfiguration redisCacheConfiguration =
        RedisCacheConfiguration.defaultCacheConfig()
            .serializeValuesWith(
                RedisSerializationContext.SerializationPair.fromSerializer(
                    redisTemplate.getValueSerializer()));
    return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
  }
}

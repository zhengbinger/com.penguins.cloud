package com.penguins.cloud.user.provider.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自动幂等注解
 *
 * @author 郑冰
 * @date 2021/8/26 18:06
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoIdempotent {
}

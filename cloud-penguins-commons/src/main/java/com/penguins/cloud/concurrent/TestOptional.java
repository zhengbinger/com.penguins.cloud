package com.penguins.cloud.concurrent;

import java.util.Optional;

/**
 * @author 郑冰
 * @date 2021/12/4 01:24
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class TestOptional {

    public static void main(String[] args) {
        Optional<Long> optional = Optional.of(10L);
        Long a = optional.get();
        System.out.println(a);
        Optional<Long> optional1 = Optional.empty();
        System.out.println(optional1.get());
        Optional<Long> optional12 = Optional.ofNullable(null);
        System.out.println(optional12.get());
    }

}

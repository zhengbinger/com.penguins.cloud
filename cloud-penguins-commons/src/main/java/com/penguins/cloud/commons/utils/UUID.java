package com.penguins.cloud.commons.utils;

/**
 * @author 郑冰
 * @date 2021/7/23 17:47
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class UUID {

    public static String uuid32() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }
}

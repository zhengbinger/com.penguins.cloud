package com.penguins.cloud.user.provider.config;


/**
 * @author 郑冰
 * @date 2021/8/20 17:35
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class Test {

    private int x;

    public static void main(String[] args) {

        String a;
        Test test = new Test();
        System.out.println(test.x);
        System.out.println(test.x++);
        System.out.println(test.x);
        System.out.println();
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
//        print(123 + "");

    }
}

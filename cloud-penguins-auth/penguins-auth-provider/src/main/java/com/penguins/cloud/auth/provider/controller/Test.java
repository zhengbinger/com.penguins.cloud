package com.penguins.cloud.auth.provider.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author zhengbing
 * @date 2021/4/28 00:38
 * @email mydreambing@126.com
 */
public class Test {
  public static void main(String[] args) {
    System.out.println(new BCryptPasswordEncoder().encode("app"));
  }
}

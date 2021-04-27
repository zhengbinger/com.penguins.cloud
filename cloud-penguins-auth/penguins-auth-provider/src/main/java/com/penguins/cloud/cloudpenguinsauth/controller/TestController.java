package com.penguins.cloud.cloudpenguinsauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 测试 Controller
 *
 * @author zhengbing
 * @date 2021/3/23 10:52
 * @email mydreambing@126.com
 */
@RestController
public class TestController {

  @Autowired private PasswordEncoder passwordEncoder;

  //    @GetMapping("test")
  //    public String test() {
  //        return UUID.randomUUID().toString();
  //    }

  @GetMapping("fail")
  public String fail() {
    return "fail";
  }

  @GetMapping("success")
  public String success() {
    return "success";
  }

  @GetMapping("encode")
  public String encode(String password) {
    return passwordEncoder.encode(password);
    //    return "";
  }
  /**
   * 获取授权的用户信息
   *
   * @param principal 当前用户
   * @return 授权信息
   */
  @GetMapping("current/get")
  public Principal user(Principal principal) {
    return principal;
  }

  @GetMapping("/foo/test")
  public String test() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    System.out.println("current authentication: 【 {} 】" + authentication);
    return "success";
  }
}

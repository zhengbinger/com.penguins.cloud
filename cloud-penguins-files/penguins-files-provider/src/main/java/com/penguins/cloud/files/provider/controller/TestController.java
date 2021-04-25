package com.penguins.cloud.files.provider.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试 Controller
 *
 * @author zhengbing
 * @date 2021/3/24 11:34
 * @email mydreambing@126.com
 */
@RestController
@RequestMapping("/r")
public class TestController {

  /**
   * 拥有p1权限方可访问
   *
   * @return String
   */
  @GetMapping(value = "/r1")
  @PreAuthorize("hasAnyAuthority('p1')")
  public String r1() {
    return "访问资源1";
  }

  /** 拥有p2权限方可访问 */
  @GetMapping(value = "/r2")
  @PreAuthorize("hasAnyAuthority('p2')")
  public String r2() {
    return "访问资源2";
  }
}

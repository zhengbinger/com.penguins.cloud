package com.penguins.cloud.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengbing
 * @date 2021/3/15 17:36
 * @email mydreambing@126.com
 */
@RestController
@RequestMapping("test")
public class TestController {

  //    @Value("${test}")
  private String props;

  @GetMapping
  public String test() {
    return props;
  }
}

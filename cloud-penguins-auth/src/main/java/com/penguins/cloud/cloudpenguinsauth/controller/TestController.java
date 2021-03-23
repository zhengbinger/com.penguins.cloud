package com.penguins.cloud.cloudpenguinsauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 测试 Controller
 *
 * @author zhengbing
 * @date 2021/3/23 10:52
 * @email mydreambing@126.com
 */
@RestController
public class TestController {

    @GetMapping("test")
    public String test() {
        return UUID.randomUUID().toString();
    }

    @GetMapping("fail")
    public String fail() {
        return "fail";
    }

    @GetMapping("success")
    public String success() {
        return "success";
    }
}

package com.penguins.cloud.message.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 郑冰
 * @date 2022/1/4 15:15
 * @email mydreambing@126.com
 * @since jdk8
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("v1")
    public String test(HttpServletRequest request) {
        System.out.println(request.getServerPort());
        return request.getLocalPort() + "";
    }
}


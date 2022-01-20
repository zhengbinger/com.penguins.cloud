package com.penguins.cloud.files.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    /**
     * 拥有p1权限方可访问
     *
     * @return String
     */
    @GetMapping(value = "/r1")
    public String r1() {
        return "访问资源1";
    }

    /**
     * 拥有p2权限方可访问
     */
    @GetMapping(value = "/r2")
    public String r2() {
        return "访问资源2";
    }

    /**
     * 拥有p2权限方可访问
     */
    @GetMapping()
    public String r3() {
        return "访问资源3";
    }
}

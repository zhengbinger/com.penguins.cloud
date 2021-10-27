package com.penguins.cloud.user.provider.controller;

import com.penguins.cloud.web.RspResult;
import com.penguins.cloud.user.provider.config.AutoIdempotent;
import com.penguins.cloud.user.provider.service.TokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 郑冰
 * @date 2021/8/26 19:14
 * @email mydreambing@126.com
 * @since jdk8
 **/
@RestController
@RequestMapping("t")
public class BusinessController {


    @Resource
    private TokenService tokenService;

//    @Resource
//    private TestService testService;


    @PostMapping("/get/token")
    public RspResult<String> getToken() {
        String token = tokenService.createToken();
        if (StringUtils.isNotEmpty(token)) {
            return RspResult.success(token);
        }
        return RspResult.fail();
    }


    @AutoIdempotent
    @PostMapping("/test/Idempotence")
    public String testIdempotence() {
        return "1";
////        String businessResult = testService.testIdempotence();
//        if (StrUtil.isNotEmpty(businessResult)) {
//            ResultVo successResult = ResultVo.getSuccessResult(businessResult);
//            return JSONUtil.toJsonStr(successResult);
//        }
//        return StrUtil.EMPTY;
    }
}

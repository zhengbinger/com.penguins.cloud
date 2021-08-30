package com.penguins.cloud.user.provider.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 郑冰
 * @date 2021/8/26 18:08
 * @email mydreambing@126.com
 * @since jdk8
 **/
public interface TokenService {

    /**
     * 创建token
     *
     * @return
     */
    String createToken();

    /**
     * 检验token
     *
     * @param request
     * @return
     */
    boolean checkToken(HttpServletRequest request) throws Exception;

}

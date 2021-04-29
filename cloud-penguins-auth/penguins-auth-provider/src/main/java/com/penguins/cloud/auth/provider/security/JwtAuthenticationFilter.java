package com.penguins.cloud.auth.provider.security;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JwtAuthenticationFilter JWT 认证过滤器
 *
 * @author zhengbing
 * @date 2021/3/25 10:49
 * @email mydreambing@126.com
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  /** 认证如果失败由该端点进行响应 */
  //    private AuthenticationEntryPoint authenticationEntryPoint = new
  // SimpleAuthenticationEntryPoint();
  private JwtTokenGenerator jwtTokenGenerator;

  private JwtTokenStorage jwtTokenStorage;

  public JwtAuthenticationFilter(
      JwtTokenGenerator jwtTokenGenerator, JwtTokenStorage jwtTokenStorage) {
    this.jwtTokenGenerator = jwtTokenGenerator;
    this.jwtTokenStorage = jwtTokenStorage;
  }

  @Override
  protected void doFilterInternal(
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse,
      FilterChain filterChain)
      throws ServletException, IOException {}
}

package com.penguins.cloud.files.provider.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author zhengbing
 * @date 2021/4/28 00:18
 * @email mydreambing@126.com
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .requestMatchers(EndpointRequest.toAnyEndpoint())
            .permitAll()
            .antMatchers(
                    "/v2/api-docs/**",
                    "/swagger-resources/**",
                    "/doc.html",
                    "/webjars/**")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        // 统一自定义异常
        .exceptionHandling()
        .and()
        .csrf()
        .disable();
  }
}

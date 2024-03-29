package com.penguins.cloud.auth.provider.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Security Web 配置
 *
 * @author zhengbing
 * @date 2021/3/23 09:25
 * @email mydreambing@126.com
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsServiceImpl userDetailService;

  /**
   * 重写authenticationManager 不重写AuthoricationServerConfig认证中心中的AuthenticationManager无法注入
   *
   * @return
   * @throws Exception
   */
  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected UserDetailsService userDetailsService() {
    return userDetailService;
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring()
            .antMatchers(
                    "/auth/clients/**",
                    "/success",
                    "/fail",
                    "/error",
                    "/static/**",
                    "/v2/api-docs/**",
                    "/swagger-resources/**",
                    "/webjars/**",
                    "/favicon.ico");
  }

  /**
   * 验证管理配置，可配置验证数据来源
   *
   * <p>SecurityBuilder用于创建一个AuthenticationManager。 允许轻松构建<i>内存验证<i/>，LDAP身份验证，基于JDBC的身份验证，添加
   * UserDetailService 以及添加 AuthenticationProvider。
   *
   * @param auth AuthenticationManagerBuilder
   * @throws Exception Exception
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // 设置内存默认认证用户 inMemoryAuthentication
    /* 将内存验证添加到 AuthenticationManagerBuilder 并返回一个 InMemoryUserDetailsManagerConfigurer 以允许定制内存验证。
      此方法还可确保 UserDetailsService 可用于 getDefaultUserDetailsService（）方法。
      请注意，其他 UserDetailsService 可能会将此 UserDetailsService 替换为默认值。
    */
    auth.userDetailsService(userDetailsService()).passwordEncoder(new BCryptPasswordEncoder());
  }

  /**
   * 重写此方法以配置HttpSecurity。认证安全配置，http请求相关
   *
   * <p>通常，子类不应通过调用super来调用此方法，因为它可能会覆盖其配置。 默认配置为：
   *
   * <p>------ http .authorizeRequests().anyRequest().authenticated() .and() .formLogin() .and()
   * .httpBasic()
   *
   * @param http HttpSecurity
   * @throws Exception Exception
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic()
        .and()
        .cors()
        .and()
        .csrf()
        .disable();
  }
}

package com.penguins.cloud.cloudpenguinsauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
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
     * 设置密码验证器
     * NoOpPasswordEncoder  不进行加密
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new NoEnPasswordEncoder();
        return new BCryptPasswordEncoder();
    }


    @Override
    public void configure(WebSecurity web) throws Exception {

    }

    /**
     * 验证管理配置，可配置验证数据来源
     *
     * <p>SecurityBuilder用于创建一个AuthenticationManager。
     * 允许轻松构建<i>内存验证<i/>，LDAP身份验证，基于JDBC的身份验证，添加 UserDetailService 以及添加 AuthenticationProvider。
     * </p>
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
//        auth.inMemoryAuthentication()
//                .passwordEncoder(passwordEncoder())
//                .withUser("admin").password("admin123").authorities("USER");
        auth.userDetailsService(userDetailsService());
//        super.configure(auth);
    }

    /**
     * 重写此方法以配置HttpSecurity。认证安全配置，http请求相关
     * <P>通常，子类不应通过调用super来调用此方法，因为它可能会覆盖其配置。</P>
     * 默认配置为：
     * <p>
     * ------
     * http
     * .authorizeRequests().anyRequest().authenticated()
     * .and()
     * .formLogin()
     * .and()
     * .httpBasic()
     *
     * @param http HttpSecurity
     * @throws Exception Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginProcessingUrl("/test")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/test")
                .permitAll()
                .anyRequest() // 捕获所有路径
                .authenticated();

    }


    @Override
    protected UserDetailsService userDetailsService() {
        return userDetailService;
    }
}

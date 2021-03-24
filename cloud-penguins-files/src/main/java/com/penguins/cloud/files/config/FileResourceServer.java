package com.penguins.cloud.files.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * 资源服务器配置
 *
 * @author zhengbing
 * @date 2021/3/24 11:35
 * @email mydreambing@126.com
 */
@Configuration
@EnableResourceServer
public class FileResourceServer extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "FILE";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        // 资源id
        resources.resourceId(RESOURCE_ID)
                // 验证令牌的服务
                .tokenServices(tokenServices())
                .stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").access("#oauth2.hasScope('all')")
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        super.configure(http);
    }

    //

    /**
     * 资源服务令牌解析服务
     * 使用远程服务请求授权服务器校验的token，必须制定校验token 的url， client_id,client_secret
     *
     * @return ResourceServerTokenServices
     */
    @Bean
    public ResourceServerTokenServices tokenServices() {
        RemoteTokenServices service = new RemoteTokenServices();
        service.setCheckTokenEndpointUrl("http://localhost:11011/cloud-penguins-auth/oauth/check_token");
        service.setClientId("c1");
        service.setClientSecret("secret");
        return service;
    }
}

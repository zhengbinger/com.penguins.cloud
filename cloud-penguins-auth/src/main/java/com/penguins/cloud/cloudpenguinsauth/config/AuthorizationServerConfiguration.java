package com.penguins.cloud.cloudpenguinsauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.JdbcClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;

/**
 * 认证服务端配置
 *
 * @author zhengbing
 * @date 2021/1/20
 * @email mydreambing@126.com
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    public UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private TokenStore jwtTokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    /**
     * 配置授权服务器端点的非安全功能，例如令牌存储，令牌自定义，用户批准和授予类型。
     * 默认情况下，您不需要做任何事情，除非需要密码授予，在这种情况下，需要提供 AuthenticationManager
     *
     * @param endpoints
     * @throws Exception Exception
     */
    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                //token存储方式
                .tokenStore(jwtTokenStore)
                //token转换方式使用jwt
                .accessTokenConverter(jwtAccessTokenConverter)
                //用户验证
                .userDetailsService(userService)
                //支持password模式
                .authenticationManager(authenticationManager);
    }

    /**
     * 配置 ClientDetailsService，
     * 例如声明单个客户及其属性。
     * 注意，除非将AuthenticationManager 提供给configure（AuthorizationServerEndpointsConfigurer），
     * 否则不会启用密码授予（即使允许某些客户端使用）。
     * 必须声明至少一个客户端或完全自定义的定制ClientDetailsService，否则服务器将无法启动
     *
     * @param clients ClientDetailsServiceConfigurer
     * @throws Exception Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //定义客户端约束条件，这里采用数据库方式配置
        JdbcClientDetailsServiceBuilder jdbc = clients.jdbc(dataSource);
        //指定加密方式
        jdbc.passwordEncoder(passwordEncoder);
    }

    /**
     * 配置授权服务器的安全性，实际上是指 /oauth/token 端点。
     * /oauth/authorize 端点也需要安全，
     * 但这是一个普通的面向用户的端点，应该以与UI其余部分相同的方式进行安全保护，因此这里不做介绍。
     * 遵循OAuth2规范的建议，默认设置涵盖了最常见的要求，因此您无需在此处进行任何操作即可启动并运行基本服务器。
     *
     * @param security AuthorizationServerSecurityConfigurer
     * @throws Exception Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //允许客户端访问 OAuth2.0 授权接口
//        security.allowFormAuthenticationForClients();
        //允许已授权用户访问 checkToken 接口
        security.checkTokenAccess("isAuthenticated()");
        //允许已授权用户访问 获取 token 接口
        security.tokenKeyAccess("isAuthenticated()");
    }

}

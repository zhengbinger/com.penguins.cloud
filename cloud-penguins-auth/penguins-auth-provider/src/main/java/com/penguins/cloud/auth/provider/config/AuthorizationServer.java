package com.penguins.cloud.auth.provider.config; // package
// com.penguins.cloud.cloudpenguinsauth.com.penguins.cloud.files.provider.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * 认证中心服务端配置 授权服务分成三大块，可以关联记忆。 1、既然要完成，它首先得知道客户端从哪里读取 - 要进行客户端详情配置 2、既然要颁发token - 必须要定义
 * token的相关endpoint，以及 token 如何存取，以及客户端支持那些类型的 token 3、既然暴露了一些 endpoint - 对这些 endpoint 可以定义一些安全上的约束等
 *
 * <p>AuthorizationServerConfigurerAdapter 要求配置以下几个类， 这几个类是由 Spring 创建的独立配置对象，他们会被 Spring 传入
 * AuthorizationServerConfigurer 进行配置 ClientDetailsServiceConfigurer:
 * 用来配置客户端详情服务（ClientDetailService）,客户端详情信息在这里进行初始化，你可以把客户端详情信息写死在这里或者通过数据库来配置，我们这边写死在这里就好了
 * AuthorizationServerEndpointsConfigurer: 用来配置令牌（token）的访问断电和令牌服务（token services）
 * AuthorizationServerSecurityConfigurer: 用来配置令牌端点的安全约束
 *
 * @author zhengbing
 * @date 2021/3/23 19:19
 * @email mydreambing@126.com
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

  //    @Autowired
  //    public PasswordEncoder passwordEncoder;

  @Autowired private DataSource dataSource;
  //
  //    @Autowired
  //    private JwtAccessTokenConverter jwtAccessTokenConverter;

  //
  //    @Autowired
  //    public UserDetailsServiceImpl userService;

  @Autowired private ClientDetailsService clientDetailsService;

  @Autowired private AuthenticationManager authenticationManager;

  @Autowired private TokenStore tokenStore;

  @Autowired private AuthorizationCodeServices authorizationCodeServices;

  /** access_token存储器 这里存储在数据库，大家可以结合自己的业务场景考虑将access_token存入数据库还是redis */
  @Bean
  public TokenStore tokenStore() {
    return new JdbcTokenStore(dataSource);
  }

  /** 从数据库读取clientDetails相关配置 有InMemoryClientDetailsService 和 JdbcClientDetailsService 两种方式选择 */
  @Bean
  public ClientDetailsService clientDetails() {
    return new JdbcClientDetailsService(dataSource);
  }

  /** 注入密码加密实现器 */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  @Bean
  public AuthorizationCodeServices authorizationCodeServices() {
    return new InMemoryAuthorizationCodeServices();
  }

  /**
   * 配置 Token 服务
   *
   * @return AuthorizationServerTokenServices
   */
  public AuthorizationServerTokenServices tokenServices() {
    tokenStore = new JdbcTokenStore(dataSource);

    DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
    defaultTokenServices.setClientDetailsService(clientDetailsService);
    // 是否产生刷新令牌
    defaultTokenServices.setSupportRefreshToken(true);
    // 设置令牌存储策略
    defaultTokenServices.setTokenStore(tokenStore);
    // 令牌默认有效期 2 小时
    defaultTokenServices.setAccessTokenValiditySeconds(7200);
    // 刷新令牌的有效时间（以秒为单位）。如果小于或等于零，则令牌将不过期
    defaultTokenServices.setRefreshTokenValiditySeconds(259200);
    return defaultTokenServices;
  }

  /**
   * 配置授权服务器端点的非安全功能，例如令牌存储，令牌自定义，用户批准和授予类型。 默认情况下，您不需要做任何事情，除非需要密码授予，在这种情况下，需要提供
   * AuthenticationManager
   *
   * @param endpoints AuthorizationServerEndpointsConfigurer
   * @throws Exception Exception
   */
  @Override
  public void configure(final AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    //        endpoints
    //                //token存储方式
    //                .tokenStore(jwtTokenStore)
    //                //token转换方式使用jwt
    //                .accessTokenConverter(jwtAccessTokenConverter)
    //                //用户验证
    //                .userDetailsService(userService)
    //                //支持password模式
    //                .authenticationManager(authenticationManager);

    endpoints
        // 密码管理模式
        .authenticationManager(authenticationManager)
        // 授权码模式
        .authorizationCodeServices(authorizationCodeServices)
        // 令牌管理服务
        .tokenServices(tokenServices())
        // 允许post提交
        .allowedTokenEndpointRequestMethods(HttpMethod.POST, HttpMethod.GET);
  }

  /**
   * 配置 ClientDetailsServiceConfigurer 负责查找 ClientDetails 例如声明单个客户及其属性。 注意，除非将 AuthenticationManager
   * 提供给 configure（AuthorizationServerEndpointsConfigurer）， 否则不会启用密码授予（即使允许某些客户端使用）。
   * 必须声明至少一个客户端或完全自定义的定制ClientDetailsService，否则服务器将无法启动
   *
   * @param clients ClientDetailsServiceConfigurer
   * @throws Exception Exception
   */
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.withClientDetails(clientDetails());
    //    clients
    //        .inMemory() // 使用内存存储
    //        .withClient("c1")
    //        // 客户端密钥
    //        .secret(new BCryptPasswordEncoder().encode("secret"))
    //        // 资源列表
    //        .resourceIds("FILE")
    //        // 授权方式
    //        .authorizedGrantTypes(
    //            "authorization_code", "password", "client_creentials", "implicit",
    // "refresh_token")
    //        // 允许授权的范围
    //        .scopes("all")
    //        // false 跳转到授权页面
    //        .autoApprove(true)
    //        // 加上验证回调地址
    //        .redirectUris("http://www.baidu.com");
    // 定义客户端约束条件，这里采用数据库方式配置
    //        JdbcClientDetailsServiceBuilder jdbc = clients.jdbc(dataSource);
    // 指定加密方式
    //        jdbc.passwordEncoder(passwordEncoder);

  }

  /**
   * 配置授权服务器的安全性，实际上是指 /oauth/token 端点。 /oauth/authorize 端点也需要安全，
   * 但这是一个普通的面向用户的端点，应该以与UI其余部分相同的方式进行安全保护，因此这里不做介绍。
   * 遵循OAuth2规范的建议，默认设置涵盖了最常见的要求，因此您无需在此处进行任何操作即可启动并运行基本服务器。
   *
   * <p>/oauth/authorize 授权端点 /oauth/token 令牌断点 /oauth/confirm-access 用户确认授权提交端点 /auth/error
   * 授权服务错误信息断电 /auth/check_token 用户资源服务访问的令牌解析断电 /oauth/token_key 提供公有密钥的端点，如果你使用jwt令牌的话
   *
   * @param security AuthorizationServerSecurityConfigurer
   * @throws Exception Exception
   */
  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    security
        .allowFormAuthenticationForClients() // 如果使用表单认证则需要加上
        .tokenKeyAccess("permitAll()")
        .checkTokenAccess("isAuthenticated()");
    //    // 允许客户端访问 OAuth2.0 授权接口
    //        security.allowFormAuthenticationForClients();
    //    //        允许已授权用户访问 checkToken 接口
    //        security.checkTokenAccess("isAuthenticated()");
    //    // 允许已授权用户访问 获取 token 接口
    //        security.tokenKeyAccess("isAuthenticated()");
    //        security
    // /oauth/token_key  公开
    //                .tokenKeyAccess("permitAll()")
    //                // /auth/check_token  检测令牌
    //                .checkTokenAccess("permitAll()")
    // 允许通过表单认证，申请令牌
    //                .allowFormAuthenticationForClients();

  }
}

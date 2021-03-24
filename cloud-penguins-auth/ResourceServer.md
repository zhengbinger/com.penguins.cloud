@EnableResourceServer 注解到一个@Configuration 配置类上，并且必须使用 ResourceServerConfigurer 这个配置对象来进行配置。 下面是一些可以配置的属性

```text
tokenServices：ResourceServerTokenServices 类的实例，用来实现令牌服务 
tokenStore：TokenStore类的实力，制定令牌如何访问，与tokenServices 配置可选
resourceId ： 这个资源服务器的id，这个属性是可选的，但是推荐设置并在授权服务中进行验证 其他的拓展例tokenExtractor 令牌提取器用来提取请求中的令牌.
HttpSecurity 配置这个与 SpringSecurity 类似请求匹配器，用来设置需要进行保护的资源路径，默认的情况下是保护资源服务器全部路径。 
通过http.authorizeRequests() 来设置受保护资源的访问规则 其他的自定义权限保护规则通过 httpSecurity 来进行配置
```

@EnableResourceServer 注解自动增加了一个类型为Oauth2AuthenticationProcessingFilter 的过滤器链

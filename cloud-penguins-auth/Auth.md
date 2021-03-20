# 认证中心使用指引

## 引入依赖

```groovy
implementation 'org.springframework.boot:spring-boot-starter-web'
implementation 'org.springframework.boot:spring-boot-starter-security'
implementation 'org.springframework.cloud:spring-cloud-starter-bootstrap'
```

## 启动应用

进入应用
<http://localhost:11011>

会进入 spring security 默认的登陆页面
![img.png](assert/login.png)

默认用户名为：user 默认密码，在启动标准输出有打印出来
![img.png](assert/password.png)

在配置文件中配置默认用户名/密码

```yaml
  security:
    user:
      name: admin
      password: admin
```
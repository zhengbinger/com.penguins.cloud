Json Web Token （JWT） 近几年是前后端分离常用的 Token 技术，是目前最流行的跨域身份验证解决方案。你可以通过文章 一文了解web无状态会话token技术JWT 来了解 JWT。今天我们来手写一个通用的 JWT 服务。

## spring-security-jwt

spring-security-jwt 是 Spring Security Crypto 提供的 JWT 工具包 。

```groovy
implementation 'org.springframework.security:spring-security-jwt:1.1.1.RELEASE'
```

核心类只有一个: org.springframework.security.jwt.JwtHelper 。它提供了两个非常有用的静态方法

## JWT 编码

JwtHelper 提供的第一个静态方法是 encode(CharSequence content, Signer signer)，这个是用来生成jwt的方法 需要指定 payload 跟 signer 签名算法。payload
存放了一些可用的不敏感信息：

- iss jwt签发者
- sub jwt所面向的用户
- aud 接收jwt的一方
- iat jwt的签发时间
- exp jwt的过期时间，这个过期时间必须要大于签发时间 iat
- jti jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击

除了以上提供的基本信息外，我们可以定义一些我们需要传递的信息，比如目标用户的权限集 等等。切记不要传递密码等敏感信息 ，因为 JWT 的前两段都是用了 BASE64 编码，几乎算是明文了

### 构建 JWT 中的 payload

通过建造类 JwtClaimsBuilder 我们可以很方便来构建 JWT 所需要的 payload json 字符串传递给 encode(CharSequence content, Signer signer) 中的 content

### 生成 RSA 密钥并进行签名

为了生成 JWT Token 我们还需要使用 RSA 算法来进行签名。 这里我们使用 JDK 提供的证书管理工具 Keytool 来生成 RSA 证书 ，格式为 jks 格式。

```shell
keytool -genkey -alias penguinscn -keypass penguinscn -keyalg RSA -storetype PKCS12 -keysize 1024 -validity 365 -keystore /Users/zhengbing/keystores/penguins.jks -storepass 123456  -dname "CN=(Penguins), OU=(penguinscn), O=(penguinscn), L=(zz), ST=(hn), C=(cn)"
```

## JWT 解码

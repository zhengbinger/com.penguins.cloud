# gradle 相关问题

## 模块间相互依赖的问题

问题描述：模块间代码互相引用，会出现IDEA 可引用到,但是编译过程中无法找到被引用代码的问题   
问题原因：子模块未打包成 jar 包时被依赖引用的问题   
解决办法：在被引用的模块的 gradle 配置文件中添加配置

```groovy
jar.enabled = true
```

## openFeign 重复使用问题

报错信息如下

```
Description:

The bean 'penguins-user-provider.FeignClientSpecification' could not be registered. A bean with that name has already been defined and overriding is disabled.

Action:

Consider renaming one of the beans or enabling overriding by setting spring.main.allow-bean-definition-overriding=true```
```

以上问题报错的意思是一个项目中存在多个接口使用@FeignClient调用同一个服务，意思是说一个服务只能用@FeignClient使用一次。

问题解决：一、 在application.properties文件加入以下代码： 允许存在多个Feign调用相同Service的接口

```java

spring.main.allow-bean-definition-overriding=true

```

以上代码可以使多个接口使用@FeignClient调用同一个服务。

问题解决：二、在一个应用中对同一个远程服务的调用只使用一次 FeignClient

## 数据未序列化的问题

```java

java.lang.IllegalArgumentException:DefaultSerializer requires a Serializable payload but received an object of
        type[com.penguins.cloud.user.api.entity.User]

```

问题原因：缓存数据未进行序列化   
解决办法：给需要缓存的对象加上 Serializable


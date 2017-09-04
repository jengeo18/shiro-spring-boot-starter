#Shiro Spring Boot Starter

Shiro Spring Boot Starter将帮助你在Spring Boot环境中使用Shiro

### 依赖

<dependency>
    <groupId>com.github.jengeo18</groupId>
    <artifactId>shiro-spring-boot-starter</artifactId>
    <version>0.0.1</version>
</dependency>

### 配置

在application.properties指定配置文件路径：

```
shiro.config.location=classpath:shiro.ini
```

在shiro.ini中配置你需要的配置（缓存，过滤器，认证策略等等）：

```
[main]
authc.loginUrl=/login
authc.usernameParam=username
authc.passwordParam=password
authc.successUrl=/index
authc.failureKeyAttribute=shiroLoginFailure

perms.unauthorizedUrl=/unauthorized
roles.unauthorizedUrl=/unauthorized

logout.redirectUrl=/index


#myRealm=top.jengeo.shiro.MyRealm
#securityManager.realms=$myRealm

[users]
zhang=123,admin
wang=123

[roles]
admin=user:*,menu:*

[urls]
/static/**=anon
/login=authc
/logout=logout
/role=authc,roles[admin]
/permission=authc,perms["user:create"]
/**=authc
```
Shiro自定义配置可参考[Shiro文档](http://shiro.apache.org/documentation.html)




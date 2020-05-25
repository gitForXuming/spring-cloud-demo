# spring-cloud-demo
github: https://github.com/gitForXuming/spring-cloud-demo.git
目前也是初次学习使用 spring boot、 spring cloud 、分布式, 搭建了一个简单spring cloud项目，

srping boot 版本：2.0.1.RELEASE
spring cloud版本：Finchley.RC1
（考虑降一下 新版本资料少）
Eureka：8761、8762    控制台访问：http://127.0.0.1/8761
provider：9000、9001
feign：8082、8083
zuul：8080、8081  (oauth2权限校验)
dashboard：9101
oauth2：6001
cas server：9080  (重构中)
项目访问：http://127.0.0.1:8080/demo/index

目前架构：
                                            cas认证 ←—————tickek校验————————---
                                                ↑                                           |
                                                |                                            |
nginx(轮询模式) --cookie(TGC)------> zuul(session、token、TGT持久) ----(token&ticket)----> feign(多个) ----> service/dao(多个)
                                                |                                            |
                                                ↓                                           |
                                            oauth2授权 ←————token 鉴权—————————


前端：
打算使用 thymeleaf

持久层：
myBatis + oracle , redis

事物：
就myBatis简单事物 不打算使用分布式事物

缓存：
打算使用redis

session：
通过spring session 持久到redis ,应用在 zuul层,会话校验也在zuul层
设置 sensitiveHeaders: Authorization 将会话传递到下一个服务（下一个服务也必须集成spring session）
已经验证通过nginx轮询到多个zull session可以共享

分布式锁：
通过redis实现

OAuth2.0
获取token：http://127.0.0.1:6001/oauth/token

cas server: war
http://127.0.0.1:9080/cas/login

配置文件：
spring cloud configuration （添加手动刷新不生效 考虑引入RabbitMQ）

下一步计划引入：
spring cloud bus 、docker




# spring-cloud-demo
github: https://github.com/gitForXuming/spring-cloud-demo.git </br>
目前也是初次学习使用 spring boot、 spring cloud 、分布式, 搭建了一个简单spring cloud项目，没经验 使用不熟导致很多地方处理都很牵强，
本次分享出来也是希望有高人帮忙提点一二，给一些建设性意见，帮助提升，早日使用到项目中，勿喷！ 交流QQ:443458144 加Q注明:git spring cloud
共勉！

srping boot 版本：2.0.1.RELEASE
spring cloud版本：Finchley.RC1
（考虑降一下 新版本资料少）

项目访问：http://127.0.0.1:8081/demo/index

目前架构：
nginx(轮询模式) -> zuul(session持久)(多个) -> feign(多个) -> service/dao(多个)

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

配置文件：
spring cloud configuration （添加手动刷新不生效 考虑引入RabbitMQ）

下一步计划引入：
spring cloud bus 、docker




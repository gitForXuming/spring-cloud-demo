# spring-cloud-demo
github: https://github.com/gitForXuming/spring-cloud-demo.git
目前也是初次学习使用 spring boot、 spring cloud 、分布式, 搭建了一个简单spring cloud项目，没经验 使用不熟导致很多地方处理都很牵强，
本次分享出来也是希望有高人帮忙提点一二，给一些建设性意见，帮助提升，早日使用到项目中，勿喷！ 交流QQ:443458144 加Q注明:git spring cloud
共勉！

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
将sessionID addZuulRequestHeader到下一个服务，下个服务通过sessionID去redis操作session(感觉比较low)

分布式锁：
通过redis实现

下一步计划引入：
spring cloud configuration 、spring cloud bus、docker




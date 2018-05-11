# spring-cloud-demo
目前也是初次学习使用 spring boot spring cloud , 搭建了一个简单spring cloud项目，没经验 使用不熟导致很多地方处理都很牵强，
本次分享出来也是希望有高人帮忙提点一下，给一些建设性意见，帮助提升，早日使用到项目中，勿喷！ 交流QQ:443458144 加Q注明:git spring cloud
共勉！

目前架构：
nginx -> zuul(多个) -> feign(多个) -> service/dao(多个)


session：
通过spring session 持久到redis ,应用在 zuul层


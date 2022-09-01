# HappyPush
一群程序员的浪漫推送

## 架构文档

### 模块划分

#### happypush



#### happypush-system
happypush-system 模块属于系统业务逻辑模块

#### happypush-api

happypush-api 模块用来收口不同模块之前的请求，因为系统更新迭代，不同模块拆分出去成一个个微服务后，api收口会极大减少影响面

#### happypush-dependency

happypush-dependency 模块负责对各个模块依赖的收口，保证项目中各个模块使用的第三方包版本都统一，避免第三方包管理混乱。

#### happypush-monitor

happypush-monitor 模块负责对整个系统的技术监控，采用Spring Boot Admin技术栈

Spring Boot Admin 是开源社区孵化的项目，用于对 Spring Boot 应用的管理和监控。Spring Boot Admin 分为服务端(spring-boot-admin-server)和客户端(spring-boot-admin-client)，服务端和客户端之间采用 http 通讯方式实现数据交互；单体项目中需要整合 spring-boot-admin-client 才能让应用被监控。在 SpringCloud 项目中，spring-boot-admin-server 是直接从注册中心抓取应用信息，不需要每个微服务应用整合 spring-boot-admin-client 就可以实现应用的管理和监控。

#### happypush-push

happypush-push 模块负责推送，单独把推送划分成一个模块是因为推送和用户关系绑定等是属于不同的限界上下文，方便以后单独成立成一个系统
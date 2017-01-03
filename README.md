# 项目部署步骤

## hosts配置
### windows
    修改C:\Windows\System32\drivers\etc\hosts配置，
    添加：127.0.0.1	discovery discovery1 discovery2 config-server gateway movie user feign ribbon

## 启动discovery-eureka应用
    java -jar discovery-eureka-1.0.jar --spring.profiles.active=discovery1
    java -jar discovery-eureka-1.0.jar --spring.profiles.active=discovery2
    访问：
        http://discovery1:8761   
        http://discovery1:8762

## 启动provider-user服务提供者
    java -jar provider-user-1.0.jar
    访问：
        http://localhost:8000/user/1
        http://localhost:8000/instance-info
    
## 启动consumer服务消费者
> ribbon

    java -jar consumer-movie-ribbon-1.0.jar
    访问： http://localhost:8010/ribbon/1
    
> feign

    java -jar consumer-movie-feign-1.0.jar
    访问： http://localhost:8011/feign/1
    
> ribbon-hystrix

    java -jar consumer-movie-ribbon-hystrix-1.0.jar
    访问： http://localhost:8012/ribbon_hystrix/1
    访问监控数据：http://localhost:8012/hystrix.stream
    
## 启动监控
> hystrix-dashboard

    java -jar hystrix-dashboard-1.0.jar
    访问：http://localhost:8020/hystrix.stream
    在地址栏输入：http://localhost:8012/hystrix.stream
    
> turbine

    需要启动hystrix-dashboard
    java -jar hystrix-turbine-1.0.jar
    访问：http://localhost:8020/hystrix.stream
    在地址栏输入：http://localhost:8021/turbine.stream
    
## 配置中心
> 获取git上的资源信息遵循如下规则：

    /{application}/{profile}[/{label}]
    /{application}-{profile}.yml
    /{label}/{application}-{profile}.yml
    /{application}-{profile}.properties
    /{label}/{application}-{profile}.properties
    
> config-server

    访问：
    http://localhost:8030/config-client-dev.properties
    http://localhost:8030/config-client/dev
    
> config-client

    访问：
    http://localhost:8031/hello
    
> config-server-eureka

    访问：
    http://localhost:8032/config-client-eureka-dev.properties
    http://localhost:8032/config-client-eureka/dev
    
> config-client-eureka

    http://localhost:8033/hello

***注意：当服务发现是 Eureka 及 Consul 时，Config Server支持与之联合使用；如果是 Zookeeper 做服务发现，目前不支持与之联合使用。***
   
    
***bootstrap.yml 文件中的内容不能放到 application.yml 中，否则config部分无法被加载，
因config部分的配置先于 application.yml 被加载，而 bootstrap.yml 中的配置会先于 application.yml 加载***

***注：springcloud应用启动相当耗内存，单个应用可以达到700MB以上，实在太消耗内存***

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
    访问： http://localhost:8020/feign/1
    
> ribbon-hystrix

    java -jar consumer-movie-ribbon-hystrix-1.0.jar
    访问： http://localhost:8030/ribbon_hystrix/1
    访问监控数据：http://localhost:8030/hystrix.stream
    
## 启动监控
> hystrix-dashboard

    java -jar hystrix-dashboard-1.0.jar
    访问：http://localhost:8040/hystrix.stream
    在地址栏输入：http://localhost:8030/hystrix.stream
    
> turbine

    需要启动hystrix-dashboard
    java -jar hystrix-turbine-1.0.jar
    访问：http://localhost:8040/hystrix.stream
    在地址栏输入：http://localhost:8031/turbine.stream
    


***注：springcloud应用启动相当耗内存，单个应用可以达到700MB以上，实在太消耗内存***

# 项目部署步骤

## hosts配置
### windows
    修改C:\Windows\System32\drivers\etc\hosts配置，
    添加：127.0.0.1 discovery discovery2 config-server gateway movie user feign ribbon

## 启动microservice-discovery应用
> 单机

    java -jar microservice-discovery-1.0.jar
    访问：
        http://discovery:8761

> 高可用

    java -jar microservice-discovery-1.0.jar --spring.profiles.active=discovery
    java -jar microservice-discovery-1.0.jar --spring.profiles.active=discovery2
    访问：
        http://discovery:8761   
        http://discovery2:8762

## 启动microservice-provider-user服务提供者
    java -jar microservice-provider-user-1.0.jar
    访问：
        http://localhost:8000/user/1
        http://localhost:8000/instance-info
    
## 启动consumer服务消费者 
> feign-hystrix

    java -jar microservice-consumer-movie-feign-1.0.jar
    访问： http://localhost:8020/feign/1
    访问监控数据：http://localhost:8020/hystrix.stream
    
## 启动监控
> hystrix-dashboard

    java -jar microservice-hystrix-dashboard-1.0.jar
    访问：http://localhost:8030/hystrix.stream
    在地址栏输入：http://localhost:8020/hystrix.stream
    
> turbine

    需要启动hystrix-dashboard
    java -jar microservice-hystrix-turbine-1.0.jar
    访问：http://localhost:8030/hystrix.stream
    在地址栏输入：http://localhost:8031/turbine.stream
    
## 配置中心
> 获取git上的资源信息遵循如下规则：

    /{application}/{profile}[/{label}]
    /{application}-{profile}.yml
    /{label}/{application}-{profile}.yml
    /{application}-{profile}.properties
    /{label}/{application}-{profile}.properties
    
> config-server

    访问：
    http://localhost:8040/config-client-dev.properties
    http://localhost:8040/config-client/dev
    
> config-client

    访问：
    http://localhost:8031/hello
    
> config-server-eureka

    访问：
    http://localhost:8032/config-client-eureka-dev.properties
    http://localhost:8032/config-client-eureka/dev
    
> config-client-eureka

    http://localhost:8033/hello
    
## API GATEWAY
1. 启动discovery-eureka
2. 启动provider-user
3. 启动api-gateway


    之前通过http://localhost:8000/user/1访问服务，
    现在通过http://localhost:8040/provider-user/user/1即可访问相应服务

    如果要修改访问路径为http://localhost:8040/test/user/1
    zuul:
      routes:
        user: # 可以随便写，在zuul上面唯一即可；当这里的值 = service-id时，service-id可以不写。
          path: /test/**
          service-id: provider-user
          
    如果需要忽略某些服务，可以通过如下配置：
    zuul:
      ignored-services: provider-user  #忽略服务
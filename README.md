**1.启动discovery-eureka应用**
java -jar discovery-eureka-1.0.jar --spring.profiles.active=discovery1
java -jar discovery-eureka-1.0.jar --spring.profiles.active=discovery2
访问：
    http://discovery1:8761   
    http://discovery1:8762

**2.启动provider-user服务提供者**
java -jar provider-user-1.0.jar
访问：
    http://localhost:8000/user/1
    http://localhost:8000/instance-info
    
**3.启动consumer服务消费者**
_ribbon_
    java -jar consumer-movie-ribbon-1.0.jar
    访问： http://localhost:8010/ribbon/1
_feign_
    java -jar consumer-movie-feign-1.0.jar
    访问： http://localhost:8020/feign/1
_ribbon-hystrix_
    java -jar consumer-movie-ribbon-hystrix-1.0.jar
    访问： http://localhost:8030/ribbon_hystrix/1
    访问监控数据：http://localhost:8030/hystrix.stream
    
**4.启动hystrix-dashboard监控**
java -jar hystrix-dashboard-1.0.jar
访问：
    http://localhost:8040/hystrix.stream


**注：springcloud应用启动相当耗内存，单个应用可以达到700MB以上，实在太消耗内存。**

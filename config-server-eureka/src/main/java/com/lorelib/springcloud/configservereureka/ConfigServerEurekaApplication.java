package com.lorelib.springcloud.configservereureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by listening on 2017/1/3.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigServerEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerEurekaApplication.class, args);
    }
}

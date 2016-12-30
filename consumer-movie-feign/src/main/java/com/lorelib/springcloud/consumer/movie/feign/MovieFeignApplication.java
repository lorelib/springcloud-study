package com.lorelib.springcloud.consumer.movie.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by listening on 2016/12/30.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MovieFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieFeignApplication.class, args);
    }
}

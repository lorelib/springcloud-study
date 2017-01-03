package com.lorelib.springcloud.configeureka.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RefreshScope注解不能少，否则即使调用refresh，配置也不会刷新
 * Created by listening on 2017/1/2.
 */
@RestController
@RefreshScope
public class ConfigClientEurekaController {
    @Value("${profile}")
    private String profile;

    @GetMapping("/hello")
    public String hello() {
        return profile;
    }
}

package com.lorelib.springcloud.consumer.movie.feign.controller;

import com.lorelib.springcloud.consumer.movie.feign.client.UserFeignClient;
import com.lorelib.springcloud.consumer.movie.feign.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by listening on 2016/12/30.
 */
@RestController
public class FeignController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("feign/{id}")
    public User findByIdFeign(@PathVariable Long id) {
        return userFeignClient.findByIdFeign(id);
    }
}

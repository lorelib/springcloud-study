package com.lorelib.springcloud.consumer.movie.feign.client;

import com.lorelib.springcloud.consumer.movie.feign.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by listening on 2016/12/30.
 */
@FeignClient(name = "provider-user")
public interface UserFeignClient {
    @RequestMapping("/user/{id}")
    User findByIdFeign(@RequestParam("id") Long id);
}

package com.lorelib.springcloud.movie.feign.feign;

import com.lorelib.springcloud.movie.feign.entity.User;
import com.lorelib.springcloud.movie.feign.feign.circuitbreaker.UserFeignClientFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author listening
 * @date 2018-04-23 13:30
 * @since v1.0
 */
@FeignClient(name = "microservice-provider-user", fallback = UserFeignClientFallback.class)
public interface UserFeignClient {
  @RequestMapping("{id}")
  User findById(@RequestParam("id") Long id);
}

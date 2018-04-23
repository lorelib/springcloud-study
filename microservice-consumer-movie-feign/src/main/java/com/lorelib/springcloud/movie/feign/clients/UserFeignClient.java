package com.lorelib.springcloud.movie.feign.clients;

import com.lorelib.springcloud.movie.feign.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author listening
 * @date 2018-04-23 13:30
 * @since v1.0
 */
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {
  @RequestMapping("{id}")
  User findById(@RequestParam("id") Long id);
}

package com.lorelib.springcloud.movie.feign.clients;

import com.lorelib.springcloud.movie.feign.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author listening
 * @date 2018-04-23 13:30
 * @since v1.0
 */
@FeignClient(name = "microservice-provider-user", fallback = UserFeignClient.UserFeignClientFallback.class)
public interface UserFeignClient {
  @RequestMapping("{id}")
  User findById(@RequestParam("id") Long id);

  @Component
  class UserFeignClientFallback implements UserFeignClient {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserFeignClientFallback.class);

    @Override public User findById(Long id) {
      LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
      User user = new User();
      user.setId(-1L);
      user.setUsername("unknown");
      user.setAge(0);
      return user;
    }
  }
}

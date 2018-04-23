package com.lorelib.springcloud.movie.feign.clients.circuitbreaker;

import com.lorelib.springcloud.movie.feign.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author listening
 * @date 2018-04-23 15:43
 * @since v1.0
 */
@Component
public class UserFeignClientFallbackt {
  private final static Logger LOGGER = LoggerFactory.getLogger(UserFeignClientFallbackt.class);

  public User findById(Long id) {
    LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
    User user = new User();
    user.setId(-1L);
    user.setUsername("unknown");
    user.setAge(0);
    return user;
  }
}

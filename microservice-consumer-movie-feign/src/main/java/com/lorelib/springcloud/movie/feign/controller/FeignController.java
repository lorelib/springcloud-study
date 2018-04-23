package com.lorelib.springcloud.movie.feign.controller;

import com.lorelib.springcloud.movie.feign.clients.UserFeignClient;
import com.lorelib.springcloud.movie.feign.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author listening
 * @date 2018-04-23 13:36
 * @since v1.0
 */
@RestController
public class FeignController {
  @Autowired
  private UserFeignClient userFeignClient;

  @GetMapping("feign/{id}")
  public User findById(@PathVariable Long id) {
    return userFeignClient.findById(id);
  }
}

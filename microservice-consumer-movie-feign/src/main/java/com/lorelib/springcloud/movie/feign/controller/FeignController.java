package com.lorelib.springcloud.movie.feign.controller;

import com.lorelib.springcloud.movie.feign.feign.UserFeignClient;
import com.lorelib.springcloud.movie.feign.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author listening
 * @date 2018-04-23 13:36
 * @since v1.0
 */
@RestController
@RefreshScope
public class FeignController {
  @Resource
  private UserFeignClient userFeignClient;
  @Value("${hello}")
  private String hello;

  @GetMapping("feign/{id}")
  public User findById(@PathVariable Long id) {
    return userFeignClient.findById(id);
  }

  @GetMapping("/hello")
  public String hello() {
    return hello;
  }
}

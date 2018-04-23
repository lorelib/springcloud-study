package com.lorelib.springcloud.user.controller;

import com.lorelib.springcloud.user.dao.UserRepository;
import com.lorelib.springcloud.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author listening
 * @date 2018-04-20 19:58
 * @since v1.0
 */
@RestController
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping("/{id}")
  public User findById(@PathVariable Long id) {
    User user = userRepository.findOne(id);
    return user;
  }

  /*@Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("/instance-info")
  public ServiceInstance showInfo() {
    return discoveryClient.getLocalServiceInstance();
  }*/
}

package com.lorelib.springcloud.movie.service;

import com.lorelib.springcloud.movie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author listening
 * @date 2018-04-23 11:38
 * @since v1.0
 */
@Service
public class RibbonService {
  @Autowired
  private RestTemplate restTemplate;

  public User findById(Long id) {
    return restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
  }
}

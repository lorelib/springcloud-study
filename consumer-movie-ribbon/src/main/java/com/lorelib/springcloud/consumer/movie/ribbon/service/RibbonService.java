package com.lorelib.springcloud.consumer.movie.ribbon.service;

import com.lorelib.springcloud.consumer.movie.ribbon.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by listening on 2016/12/29.
 */
@Service
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;

    public User findById(Long id) {
        return restTemplate.getForObject("http://provider-user/user/" + id, User.class);
    }
}

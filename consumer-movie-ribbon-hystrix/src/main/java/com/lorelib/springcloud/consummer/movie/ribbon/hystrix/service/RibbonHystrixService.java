package com.lorelib.springcloud.consummer.movie.ribbon.hystrix.service;

import com.lorelib.springcloud.consummer.movie.ribbon.hystrix.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by listening on 2016/12/30.
 */
@Service
public class RibbonHystrixService {
    private final static Logger LOGGER = LoggerFactory.getLogger(RibbonHystrixService.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用@HystrixCommand注解指定当该方法发生异常时调用的方法
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public User findById(Long id) {
        return restTemplate.getForObject("http://provider-user/user/" + id, User.class);
    }

    public User fallback(Long id) {
        LOGGER.info("出现异常，接收参数：id = {}", id);
        User user = new User();
        user.setId(-1L);
        user.setUsername("default username");
        return user;
    }
}

package com.lorelib.springcloud.consummer.movie.ribbon.hystrix.controller;

import com.lorelib.springcloud.consummer.movie.ribbon.hystrix.entity.User;
import com.lorelib.springcloud.consummer.movie.ribbon.hystrix.service.RibbonHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by listening on 2016/12/30.
 */
@RestController
public class RibbonHystrixController {
    @Autowired
    private RibbonHystrixService ribbonHystrixService;

    @GetMapping("/ribbon_hystrix/{id}")
    public User findById(@PathVariable Long id) {
        return ribbonHystrixService.findById(id);
    }
}

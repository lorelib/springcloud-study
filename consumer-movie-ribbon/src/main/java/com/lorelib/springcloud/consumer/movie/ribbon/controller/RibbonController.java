package com.lorelib.springcloud.consumer.movie.ribbon.controller;

import com.lorelib.springcloud.consumer.movie.ribbon.entity.User;
import com.lorelib.springcloud.consumer.movie.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by listening on 2016/12/29.
 */
@RestController
public class RibbonController {
    @Autowired
    private RibbonService ribbonService;

    @GetMapping("/ribbon/{id}")
    public User findById(@PathVariable Long id) {
        return ribbonService.findById(id);
    }
}

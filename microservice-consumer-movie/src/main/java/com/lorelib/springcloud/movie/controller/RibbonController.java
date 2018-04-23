package com.lorelib.springcloud.movie.controller;

import com.lorelib.springcloud.movie.entity.User;
import com.lorelib.springcloud.movie.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author listening
 * @date 2018-04-23 11:43
 * @since v1.0
 */
@RestController
public class RibbonController {
  @Autowired
  private RibbonService ribbonService;

  @GetMapping("ribbon/{id}")
  public User findById(@PathVariable Long id) {
    return ribbonService.findById(id);
  }
}

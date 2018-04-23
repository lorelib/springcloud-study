package com.lorelib.springcloud.movie.entity;

/**
 * @author listening
 * @date 2018-04-20 19:54
 * @since v1.0
 */
public class User  {
  private Long id;

  private String username;

  private Integer age;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}

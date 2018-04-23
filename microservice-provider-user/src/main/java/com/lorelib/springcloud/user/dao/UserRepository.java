package com.lorelib.springcloud.user.dao;

import com.lorelib.springcloud.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author listening
 * @date 2018-04-20 19:54
 * @since v1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

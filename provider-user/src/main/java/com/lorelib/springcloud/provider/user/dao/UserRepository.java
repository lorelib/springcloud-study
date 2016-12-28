package com.lorelib.springcloud.provider.user.dao;

import com.lorelib.springcloud.provider.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by listening on 2016/12/28.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

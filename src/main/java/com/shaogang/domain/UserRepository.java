package com.shaogang.domain;

import com.shaogang.bean.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by allen on 17/12/16.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);

    User findByNameAndAge(String name, String age);
}

package com.rhysnguyen.casestudyjavaweb.dao;


import com.rhysnguyen.casestudyjavaweb.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

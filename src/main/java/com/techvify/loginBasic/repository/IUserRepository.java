package com.techvify.loginBasic.repository;

import com.techvify.loginBasic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);
}

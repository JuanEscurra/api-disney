package com.challenge.apidisney.domain.dao;

import com.challenge.apidisney.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}

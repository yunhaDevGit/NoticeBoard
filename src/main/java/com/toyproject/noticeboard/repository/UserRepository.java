package com.toyproject.noticeboard.repository;

import com.toyproject.noticeboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

  User findByUsername(String username);
}

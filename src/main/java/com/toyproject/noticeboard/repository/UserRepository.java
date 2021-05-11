package com.toyproject.noticeboard.repository;

import com.toyproject.noticeboard.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, String> {

  UserInfo findByUsername(String username);
}

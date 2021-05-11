package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.model.Role;
import com.toyproject.noticeboard.model.UserInfo;
import com.toyproject.noticeboard.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class LoginControllerTest {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserRepository userRepository;

  @Test
  void join() {

    UserInfo userInfo = new UserInfo();
    userInfo.setId("user02");
    userInfo.setPassword("qwe1212");
    userInfo.setUsername("yunha2");
    userInfo.setEmail("email@email.com");
    userInfo.setContact("010-0000-0000");
    userInfo.setRole(Role.ROLE_USER);

//    userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));

    userRepository.save(userInfo);

  }
}
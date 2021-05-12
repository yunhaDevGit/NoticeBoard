package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.model.Role;
import com.toyproject.noticeboard.model.User;
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

    User user = new User();
    user.setId("user02");
    user.setPassword("qwe1212");
    user.setUsername("yunha2");
    user.setEmail("email@email.com");
    user.setContact("010-0000-0000");
    user.setRole(Role.ROLE_USER);

//    userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));

    userRepository.save(user);

  }
}
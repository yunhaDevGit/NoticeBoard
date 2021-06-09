package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.config.auth.PrincipalDetails;
import com.toyproject.noticeboard.service.UserService;
import com.toyproject.noticeboard.utils.Role;
import com.toyproject.noticeboard.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserService userService;

  @GetMapping("/loginForm")
  public String loginForm() {
    return "loginForm";
  }

  @GetMapping("/joinForm")
  public String joinForm() {
    return "joinForm";
  }

  @PostMapping("/join")
  public String join(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userService.joinUser(user);
    return "redirect:/loginForm";
  }
}

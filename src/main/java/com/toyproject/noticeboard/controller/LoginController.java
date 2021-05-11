package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.model.UserInfo;
import com.toyproject.noticeboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/loginForm")
  public String loginForm() {
    return "loginForm";
  }

  @GetMapping("/joinForm")
  public String joinForm() {
    return "joinForm";
  }

  @PostMapping("/join")
  public @ResponseBody String join(@RequestBody UserInfo userInfo) {

    userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
    userRepository.save(userInfo);
//    return "redirect:/loginForm";
    return "회원가입 완료";
  }
}

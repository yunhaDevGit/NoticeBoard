package com.toyproject.noticeboard.utils;

import java.util.HashMap;
import java.util.Map;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderFactories {
  @SuppressWarnings("deprecation")
  public static PasswordEncoder createDelegatingPasswordEncoder() {
    Map<String, PasswordEncoder> encoders = new HashMap<>();
    String encodingId = "SHA-256";
    encoders.put("bcrypt", new BCryptPasswordEncoder());
    encoders.put(encodingId , new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-256"));
    encoders.put("sha256", new org.springframework.security.crypto.password.StandardPasswordEncoder());

    return new DelegatingPasswordEncoder(encodingId, encoders);
  }

}

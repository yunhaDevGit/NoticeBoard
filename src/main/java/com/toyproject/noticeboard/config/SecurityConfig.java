package com.toyproject.noticeboard.config;

import com.toyproject.noticeboard.utils.DefaultPasswordEncoderFactories;
import com.toyproject.noticeboard.utils.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return DefaultPasswordEncoderFactories.createDelegatingPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();
    http
        .authorizeRequests()
        .antMatchers("/**/user").authenticated()
        .antMatchers("/**/list/**").permitAll()
        .antMatchers("/**/admin").hasRole("ADMIN")
        .antMatchers("/**/manager","/board/create").hasAnyRole("ADMIN", "MANAGER")
        .antMatchers("/**/write").hasAnyRole("ADMIN","MANAGER","USER")
        .anyRequest().permitAll()
        .and()
        .formLogin()
        .loginPage("/loginForm")
        .loginProcessingUrl("/login")
        .defaultSuccessUrl("/");


  }
}

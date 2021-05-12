package com.toyproject.noticeboard.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "user")
@Data
@NoArgsConstructor
public class User {

  @Id
  private String id;
  private String username;
  private String password;
  private String email;
  private String contact;
  @Enumerated(EnumType.STRING)
  private Role role;

  @Builder
  public User(String id, String username, String password, String email, String contact, Role role) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.contact = contact;
    this.role = role;
  }
}

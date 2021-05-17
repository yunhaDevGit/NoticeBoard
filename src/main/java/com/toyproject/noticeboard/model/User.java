package com.toyproject.noticeboard.model;

import javax.persistence.*;

import com.toyproject.noticeboard.utils.Role;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "user")
@Data
@NoArgsConstructor
public class User {

  @Id
  private String id;

  @Column(unique = true) // unique 속성 잘 안쓴다. 제약조건 생성 시 이름 이상하게 만들어줘서 구분하기 힘들기 때문
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

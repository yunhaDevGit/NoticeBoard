package com.toyproject.noticeboard.model;

import javax.persistence.*;

import com.toyproject.noticeboard.utils.Role;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "user")
@Data
@Table(uniqueConstraints = {@UniqueConstraint(name = "username_unique", columnNames = "username")})
@NoArgsConstructor
public class User {

  @Id
  @Column(name = "user_id")
  private String id;

//  @Column(unique = true) // unique 속성 잘 안쓴다. 제약조건 생성 시 이름 이상하게 만들어줘서 구분하기 힘들기 때문
  @Column(name = "username",nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;
  private String email;
  private String contact;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
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

  @PrePersist
  public void prePersist() {
    this.role = this.role == null ? Role.ROLE_USER : this.role;
  }
}

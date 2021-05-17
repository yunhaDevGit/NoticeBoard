package com.toyproject.noticeboard.model;

import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "board")
@Data
@NoArgsConstructor
public class Board {

  @Id
  private String id;
  private String title;

  @ManyToOne
  @JoinColumn(name = "username")
  private User user;

  @Lob
  private String text;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  @Builder
  public Board(String id, String title, User user, String text, LocalDateTime createdAt,
               LocalDateTime updatedAt) {
    this.id = id;
    this.title = title;
    this.user = user;
    this.text = text;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }
}

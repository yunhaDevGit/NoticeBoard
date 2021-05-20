package com.toyproject.noticeboard.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "post")
@Data
@NoArgsConstructor
public class Post {

  @Id
  @Column(name = "post_id")
  private String id;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne
  @JoinColumn(name = "board_id")
  private Board board;

  private String title;
  @Lob
  private String text;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @Builder
  public Post(String id, User user, Board board, String title, String text,
      LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.id = id;
    this.user = user;
    this.board = board;
    this.title = title;
    this.text = text;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }
}

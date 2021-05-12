package com.toyproject.noticeboard.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
  private String username;
  private String text;

  @Temporal(TemporalType.TIMESTAMP)
  private Date createdAt;

  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedAt;

  @Builder
  public Board(String id, String title, String username, String text, Date createdAt,
      Date updatedAt) {
    this.id = id;
    this.title = title;
    this.username = username;
    this.text = text;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }
}

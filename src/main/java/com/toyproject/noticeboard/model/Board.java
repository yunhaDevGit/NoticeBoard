package com.toyproject.noticeboard.model;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity(name = "board")
@Data
@NoArgsConstructor
public class Board {

  @Id
  @Column(name = "board_id")
  private String id;
  private String category;
  @ColumnDefault("0")
  private int postCount;

  @Builder
  public Board(String id, String category, int postCount) {
    this.id = id;
    this.category = category;
    this.postCount = postCount;
  }
}

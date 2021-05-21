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

  @Builder
  public Board(String id, String category) {
    this.id = id;
    this.category = category;
  }
}

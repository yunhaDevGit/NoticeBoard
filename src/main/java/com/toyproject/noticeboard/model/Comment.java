package com.toyproject.noticeboard.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity(name = "comment")
@Data
public class Comment {

  @Id
  @Column(name = "comment_id")
  private String id;

  @ManyToOne
  @JoinColumn(name = "post_id")
  private Post post;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "comment_id")
  private Comment parent;

  @OneToMany(mappedBy = "parent", orphanRemoval = true)
  private List<Comment> children = new ArrayList<>();

  private LocalDateTime createdAt;
  private LocalDateTime updateAt;
}

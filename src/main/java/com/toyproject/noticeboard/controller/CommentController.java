package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.config.auth.PrincipalDetails;
import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.model.Comment;
import com.toyproject.noticeboard.model.Post;
import com.toyproject.noticeboard.model.User;
import com.toyproject.noticeboard.service.BoardService;
import com.toyproject.noticeboard.service.CommentService;
import com.toyproject.noticeboard.service.PostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {

  @Autowired
  private CommentService commentService;

  @Autowired
  private PostService postService;

  @Autowired
  private BoardService boardService;

  @PostMapping(value = "/post/comment")
  public Comment postComment(Comment comment, Authentication authentication){
    PrincipalDetails user = (PrincipalDetails) authentication.getPrincipal();
    comment.setUser(user.getUser());
    Post post = postService.getPostById(comment.getPost().getId());
    comment.setPost(post);
    return commentService.postComment(comment);
  }

//  @GetMapping(value = "/comment")
//  public List<Comment> getComments(){
//
//  }
}

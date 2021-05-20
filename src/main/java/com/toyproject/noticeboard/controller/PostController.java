package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.config.auth.PrincipalDetails;
import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.model.Post;
import com.toyproject.noticeboard.repository.PostRepository;
import com.toyproject.noticeboard.service.PostService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

  @Autowired
  PostService postService;
  @Autowired
  PostRepository postRepository;


  @GetMapping("/list/all")
  @ResponseBody
  public List<Post> getPostList(){
    return postService.getPostList();
  }

  @GetMapping("/list/{category}")
  @ResponseBody
  public List<Post> getPostListInCategory(@PathVariable String category){
    Board board = new Board();
    board.setCategory(category);

    return postService.getPostListInCategory(board);
  }

  @GetMapping("/list/user/post")
  @ResponseBody
  public List<Post> getUserPost(Authentication authentication){
    PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
    return postService.getUserPost(principal.getUser());
  }

  @GetMapping("/write")
  public String write(){
    return "write";
  }

  @PostMapping("/post")
  @ResponseBody
  public Post postBoard(Post post, Authentication authentication){
    PrincipalDetails user = (PrincipalDetails) authentication.getPrincipal();
    post.setUser(user.getUser());
    post.setId(String.valueOf(UUID.randomUUID()));
    post.setCreatedAt(LocalDateTime.now());

    return postService.savePost(post);
  }
}

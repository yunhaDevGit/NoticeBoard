package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.config.auth.PrincipalDetails;
import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.model.Post;
import com.toyproject.noticeboard.service.PostService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

  @Autowired
  PostService postService;


  @GetMapping("/post/list")
  @ResponseBody
  public List<Post> getPostList(){
    return postService.getPostList();
  }

  @GetMapping("/post/list/{category}")
  @ResponseBody
  public List<Post> getPostListInCategory(@PathVariable String category){
    Board board = new Board();
    board.setCategory(category);

    return postService.getPostListInCategory(board);
  }

  @GetMapping("/post/list/user")
  @ResponseBody
  public List<Post> getUserPost(Authentication authentication){
    PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
    return postService.getUserPost(principal.getUser());
  }

  @GetMapping("/post/write")
  public String write(){
    return "write";
  }

  @PostMapping("/post/write")
  @ResponseBody
  public Post postBoard(Post post, Authentication authentication){
    PrincipalDetails user = (PrincipalDetails) authentication.getPrincipal();
    post.setUser(user.getUser());
    post.setId(String.valueOf(UUID.randomUUID()));
    post.setCreatedAt(LocalDateTime.now());

    return postService.savePost(post);
  }

  @DeleteMapping("/post/delete/{id}")
  public void deletePost(@PathVariable String id){
    postService.deletePost(id);
  }

  @GetMapping("/page/admin")
  @ResponseBody
  public String adminPage(){
    return "관리자 페이지";
  }

  @GetMapping("/page/manager")
  @ResponseBody
  public String managerPage(){
    return "매니저 페이지";
  }
}

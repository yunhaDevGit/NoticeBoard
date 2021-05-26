package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.model.Post;
import com.toyproject.noticeboard.model.User;
import com.toyproject.noticeboard.repository.BoardRepository;
import com.toyproject.noticeboard.repository.PostRepository;
import com.toyproject.noticeboard.repository.UserRepository;
import com.toyproject.noticeboard.service.PostService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;

@SpringBootTest
class PostControllerTest {

  @Autowired
  PostService postService;
  @Autowired
  BoardRepository boardRepository;
  @Autowired
  UserRepository userRepository;

  @Test
  void getPostList() {
    List<Post> posts = postService.getPostList();
    for (Post post:posts)
      System.out.println(post);
  }

  @Test
  void getPostListInCategory() {

    Board board = boardRepository.findByCategory("free");

    List<Post> posts = postService.getPostListInCategory(board);
    for(Post post : posts){
      System.out.println(post);
    }
  }

  @Test
  void getUserPost() {
    User user = new User();
    user.setId("user01");
    user.setUsername("user01");
    List<Post> posts = postService.getUserPost(user);
    for (Post post : posts) {
      System.out.println(post);
    }
  }

  @Test
  void postBoard() {

    User user = userRepository.findByUsername("user01");

    Board board = new Board();
    board.setCategory("free");

    Post post = new Post();
    post.setId(String.valueOf(UUID.randomUUID()));
    post.setText("testsetssdfsdet");
    post.setTitle("setstes");
    post.setCreatedAt(LocalDateTime.now());
    post.setUser(user);
    post.setBoard(board);

    postService.savePost(post);
  }
}
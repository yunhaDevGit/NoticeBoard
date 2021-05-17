package com.toyproject.noticeboard.repository;

import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.model.User;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardRepositoryTest {

  @Autowired
  BoardRepository boardRepository;

  @Test
  public void findAll() {
    User user = new User();
    user.setUsername("yunha");

    boardRepository.save(Board.builder()
        .id("id01")
        .title("title1")
        .user(user)
        .text("hello")
        .build());
    boardRepository.save(Board.builder()
        .id("id02")
        .title("title2")
        .user(user)
        .text("hi")
        .build());

    List<Board> freeboardList = boardRepository.findAll();
    System.out.println(freeboardList);
  }

  @Test
  public void findByUserName() {
    String username = "yunha";

    List<Board> freeboardList = boardRepository.findByUser(username);
    System.out.println(freeboardList);
  }
}
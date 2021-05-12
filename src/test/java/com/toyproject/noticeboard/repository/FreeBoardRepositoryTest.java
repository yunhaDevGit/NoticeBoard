package com.toyproject.noticeboard.repository;

import com.toyproject.noticeboard.model.Board;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FreeBoardRepositoryTest {

  @Autowired
  FreeBoardRepository freeBoardRepository;

  @Test
  public void findAll() {
    freeBoardRepository.save(Board.builder()
        .id("id01")
        .title("title1")
        .username("yunha")
        .text("hello")
        .build());
    freeBoardRepository.save(Board.builder()
        .id("id02")
        .title("title2")
        .username("jeong")
        .text("hi")
        .build());

    List<Board> freeboardList = freeBoardRepository.findAll();
    System.out.println(freeboardList);
  }

  @Test
  public void findByUserName() {
    String username = "yunha";

    List<Board> freeboardList = freeBoardRepository.findByUsername(username);
    System.out.println(freeboardList);
  }
}
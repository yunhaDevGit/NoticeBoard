package com.toyproject.noticeboard.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.toyproject.noticeboard.model.BoardInfo;
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
    freeBoardRepository.save(BoardInfo.builder()
        .id("id01")
        .title("title1")
        .userName("yunha")
        .text("hello")
        .build());
    freeBoardRepository.save(BoardInfo.builder()
        .id("id02")
        .title("title2")
        .userName("jeong")
        .text("hi")
        .build());

    List<BoardInfo> freeboardList = freeBoardRepository.findAll();
    System.out.println(freeboardList);
  }

  @Test
  public void findByUserName() {
    String username = "yunha";

    List<BoardInfo> freeboardList = freeBoardRepository.findByUserName(username);
    System.out.println(freeboardList);
  }
}
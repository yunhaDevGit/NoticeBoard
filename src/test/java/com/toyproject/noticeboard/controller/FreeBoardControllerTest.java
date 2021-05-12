package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.repository.FreeBoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FreeBoardControllerTest {

  @Autowired
  FreeBoardRepository freeBoardRepository;

  @Test
  public void postBoard(){
    Board board = new Board();
    board.setId("testId");
    board.setText("testText");
    board.setTitle("testTitle");
    board.setUserName("yunha");

    freeBoardRepository.save(board);
  }
}
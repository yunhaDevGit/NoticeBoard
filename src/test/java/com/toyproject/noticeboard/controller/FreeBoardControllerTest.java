package com.toyproject.noticeboard.controller;

import static org.junit.jupiter.api.Assertions.*;

import com.toyproject.noticeboard.model.BoardInfo;
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
    BoardInfo boardInfo = new BoardInfo();
    boardInfo.setId("testId");
    boardInfo.setText("testText");
    boardInfo.setTitle("testTitle");
    boardInfo.setUserName("yunha");

    freeBoardRepository.save(boardInfo);
  }
}
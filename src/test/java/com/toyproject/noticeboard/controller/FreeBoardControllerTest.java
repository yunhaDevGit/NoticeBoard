package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.repository.FreeBoardRepository;
import com.toyproject.noticeboard.service.FreeBoardService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FreeBoardControllerTest {

  @Autowired
  FreeBoardRepository freeBoardRepository;

  @Autowired
  FreeBoardService freeBoardService;

  @Test
  public void getFreeBoardList(){
    List<Board> boardList = freeBoardService.getFreeBoardList();
    for(Board board : boardList){
      System.out.println("==============");
      System.out.println(board);
    }
  }

  @Test
  public void postBoard(){
    Board board = new Board();
    board.setId("testId");
    board.setText("testText");
    board.setTitle("testTitle");
    board.setUsername("yunha");

    freeBoardRepository.save(board);
  }
}
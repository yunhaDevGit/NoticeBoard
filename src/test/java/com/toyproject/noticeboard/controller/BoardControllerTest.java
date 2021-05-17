package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.model.User;
import com.toyproject.noticeboard.repository.BoardRepository;
import com.toyproject.noticeboard.repository.UserRepository;
import com.toyproject.noticeboard.service.BoardService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardControllerTest {

  @Autowired
  BoardRepository boardRepository;

  @Autowired
  BoardService boardService;

  @Autowired
  UserRepository userRepository;

  @Test
  public void getFreeBoardList(){
    List<Board> boardList = boardService.getFreeBoardList();
    for(Board board : boardList){
      System.out.println("==============");
      System.out.println(board);
    }
  }

  @Test
  public void postBoard(){

    User user = userRepository.findByUsername("user01");

    Board board = new Board();
    board.setId("testId");
    board.setText("testText");
    board.setTitle("testTitle");
    board.setUser(user);

    boardRepository.save(board);
  }
}
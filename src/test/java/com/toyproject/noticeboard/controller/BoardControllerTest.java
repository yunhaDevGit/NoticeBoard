package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.model.User;
import com.toyproject.noticeboard.repository.BoardRepository;
import com.toyproject.noticeboard.repository.UserRepository;
import com.toyproject.noticeboard.service.BoardService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootTest
class BoardControllerTest {

  @Autowired
  BoardRepository boardRepository;

  @Autowired
  BoardService boardService;

  @Autowired
  UserRepository userRepository;

  @Test
  public void getBoardList(){
    List<Board> boards = boardService.getBoardList();
    for(Board board:boards)
      System.out.println(board);
  }

  @Test
  public void newBoard(){

    Board board = new Board();
    board.setId(String.valueOf(UUID.randomUUID()));
    board.setCategory("FreeBoard");
    boardRepository.save(board);
  }


}
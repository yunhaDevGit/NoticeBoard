package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.repository.BoardRepository;
import com.toyproject.noticeboard.service.BoardService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

  @Autowired
  BoardService boardService;

  @GetMapping("/test")
  public String test() {
    return "test";
  }


  @GetMapping("/newBoard")
  public String newBoard(){
    return "newBoard";
  }

  @PostMapping("/newBoard")
  public Board newBoard(Board board){
    board.setId(String.valueOf(UUID.randomUUID()));
    return boardService.saveBoard(board);
  }

}

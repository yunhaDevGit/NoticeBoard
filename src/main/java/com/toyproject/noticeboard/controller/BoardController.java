package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.repository.BoardRepository;
import com.toyproject.noticeboard.service.BoardService;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {

  @Autowired
  BoardService boardService;

  @GetMapping("/board/list")
  public List<Board> getBoardList(){
    return boardService.getBoardList();
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

  @DeleteMapping("/board/delete/{id}")
  public void deleteBoard(@PathVariable String id){
    boardService.deleteBoard(id);
  }
}

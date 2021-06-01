package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.service.BoardService;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

  @Autowired
  BoardService boardService;

  @GetMapping("/board/list")
  @ResponseBody
  public List<Board> getBoardList(){
    return boardService.getBoardList();
  }

  @GetMapping("/board/create")
  public String newBoard(){
    return "newBoard";
  }

  @PostMapping("/board/create")
  @ResponseBody
  public Board createBoard(Board board){
    board.setId(String.valueOf(UUID.randomUUID()));
    return boardService.createBoard(board);
  }

  @DeleteMapping("/board/delete/{id}")
  public void deleteBoard(@PathVariable String id){
    boardService.deleteBoard(id);
  }
}

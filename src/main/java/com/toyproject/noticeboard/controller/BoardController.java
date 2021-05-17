package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.model.User;
import com.toyproject.noticeboard.repository.BoardRepository;
import com.toyproject.noticeboard.service.BoardService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

  @Autowired
  BoardService boardService;
  @Autowired
  BoardRepository boardRepository;

  @GetMapping("/test")
  public String test() {
    return "test";
  }

  @GetMapping("/list/all")
  @ResponseBody
  public List<Board> getFreeBoardList(){
    return boardService.getFreeBoardList();
  }

  @GetMapping("/list/user")
  @ResponseBody
  public List<Board> getUser
      (@RequestParam String username){
    return boardService.getUserPost(username);
  }

  @PostMapping("/write")
  @ResponseBody
  public Board postBoard(@RequestBody Board board, HttpSession httpSession){
    User user = (User) httpSession.getAttribute("user");
    board.setUser(user);
    return boardRepository.save(board);
  }
}

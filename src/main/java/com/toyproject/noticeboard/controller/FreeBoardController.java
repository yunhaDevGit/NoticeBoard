package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.repository.FreeBoardRepository;
import com.toyproject.noticeboard.service.FreeBoardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FreeBoardController {

  @Autowired
  FreeBoardService freeBoardService;
  @Autowired
  FreeBoardRepository freeBoardRepository;

  @GetMapping("/test")
  public String test() {
    return "test";
  }

  @GetMapping("/list/all")
  @ResponseBody
  public List<Board> getFreeBoardList(){
    return freeBoardService.getFreeBoardList();
  }

  @GetMapping("/list/user")
  @ResponseBody
  public List<Board> getUser
      (@RequestParam String username){
    return freeBoardService.getUserPost(username);
  }

  @PostMapping("/write")
  @ResponseBody
  public Board postBoard(@RequestBody Board board){
    return freeBoardRepository.save(board);
  }
}

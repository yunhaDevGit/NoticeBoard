package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.model.BoardInfo;
import com.toyproject.noticeboard.service.FreeBoardService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/freeboard")
public class FreeBoardController {

  @Autowired
  FreeBoardService freeBoardService;

  @GetMapping("/list/all")
  @ResponseBody
  public List<BoardInfo> getFreeBoardList(){
    return freeBoardService.getFreeBoardList();
  }

  @GetMapping("/list/userBoard")
  @ResponseBody
  public List<BoardInfo> getUser
      (@RequestParam String username){
    return freeBoardService.getUserPost(username);
  }

}

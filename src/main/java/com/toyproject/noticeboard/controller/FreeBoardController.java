package com.toyproject.noticeboard.controller;

import com.toyproject.noticeboard.model.BoardInfo;
import com.toyproject.noticeboard.service.FreeBoardService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FreeBoardController {

  @Autowired
  FreeBoardService freeBoardService;

  @GetMapping("/list")
  @ResponseBody
  public List<BoardInfo> getFreeBoardList(){
    return freeBoardService.getFreeBoardList();
  }

}

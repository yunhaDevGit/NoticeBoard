package com.toyproject.noticeboard.service.impl;

import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.repository.BoardRepository;
import com.toyproject.noticeboard.service.BoardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

  @Autowired
  BoardRepository boardRepository;

  @Override
  public List<Board> getFreeBoardList() {
    return boardRepository.findAll();
  }

  @Override
  public List<Board> getUserPost(String username) {
    return boardRepository.findByUser(username);
  }
}

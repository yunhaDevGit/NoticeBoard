package com.toyproject.noticeboard.service.impl;

import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.model.Post;
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
  public Board getBoardByCategory(String category) {
    return boardRepository.findByCategory(category);
  }

  @Override
  public Board createBoard(Board board) {
    return boardRepository.save(board);
  }

  @Override
  public void deleteBoard(String id) {
    boardRepository.deleteById(id);
  }

  @Override
  public List<Board> getBoardList() {
    return boardRepository.findAll();
  }
}

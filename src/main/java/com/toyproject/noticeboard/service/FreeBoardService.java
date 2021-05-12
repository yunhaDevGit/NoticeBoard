package com.toyproject.noticeboard.service;

import com.toyproject.noticeboard.model.Board;
import java.util.List;

public interface FreeBoardService {

  List<Board> getFreeBoardList();

  List<Board> getUserPost(String username);
}

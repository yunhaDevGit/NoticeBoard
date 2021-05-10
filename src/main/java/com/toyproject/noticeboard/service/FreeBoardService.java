package com.toyproject.noticeboard.service;

import com.toyproject.noticeboard.model.BoardInfo;
import java.util.List;

public interface FreeBoardService {

  List<BoardInfo> getFreeBoardList();

  List<BoardInfo> getUserPost(String username);
}

package com.toyproject.noticeboard.service;

import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.model.Post;
import java.util.List;

public interface BoardService {

  Board getBoardByCategory(String category);

}

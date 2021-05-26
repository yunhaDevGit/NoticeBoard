package com.toyproject.noticeboard.service.impl;

import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.model.Post;
import com.toyproject.noticeboard.model.User;
import com.toyproject.noticeboard.repository.BoardRepository;
import com.toyproject.noticeboard.repository.PostRepository;
import com.toyproject.noticeboard.service.BoardService;
import com.toyproject.noticeboard.service.PostService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  @Autowired
  PostRepository postRepository;
  @Autowired
  BoardService boardService;

  @Override
  public List<Post> getPostList() {
    return postRepository.findAll();
  }

  @Transactional
  @Override
  public List<Post> getPostListInCategory(Board board) {
    board.setId(boardService.getBoardByCategory(board.getCategory()).getId());
    return postRepository.findByBoard(board);
  }

  @Override
  public List<Post> getUserPost(User user) {
    return postRepository.findByUser(user);
  }

  @Transactional
  @Override
  public Post savePost(Post post) {
    Board board = boardService.getBoardByCategory(post.getBoard().getCategory());
    post.setBoard(board);
    return postRepository.save(post);
  }
}

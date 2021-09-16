package com.toyproject.noticeboard.repository;

import com.toyproject.noticeboard.model.Board;
import com.toyproject.noticeboard.model.Post;
import com.toyproject.noticeboard.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {

  Post getById(String id);

  List<Post> findAll();

  List<Post> findByBoard(Board board);

  List<Post> findByUser(User user);

}

package com.toyproject.noticeboard.repository;

import com.toyproject.noticeboard.model.Board;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, String> {

  List<Board> findAll();

  List<Board> findByUser(String username);
}

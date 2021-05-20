package com.toyproject.noticeboard.repository;

import com.toyproject.noticeboard.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, String> {


  Board findByCategory(String category);
}

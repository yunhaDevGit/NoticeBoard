package com.toyproject.noticeboard.repository;

import com.toyproject.noticeboard.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Board, String> {

}

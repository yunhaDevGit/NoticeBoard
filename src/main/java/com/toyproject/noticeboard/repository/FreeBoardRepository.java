package com.toyproject.noticeboard.repository;

import com.toyproject.noticeboard.model.BoardInfo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeBoardRepository extends JpaRepository<BoardInfo, String> {

  List<BoardInfo> findAll();

  List<BoardInfo> findByUserName(String username);
}

package com.toyproject.noticeboard.service.impl;

import com.toyproject.noticeboard.model.BoardInfo;
import com.toyproject.noticeboard.repository.FreeBoardRepository;
import com.toyproject.noticeboard.service.FreeBoardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {

  @Autowired
  FreeBoardRepository freeBoardRepository;

  @Override
  public List<BoardInfo> getFreeBoardList() {
    return freeBoardRepository.findAll();
  }
}

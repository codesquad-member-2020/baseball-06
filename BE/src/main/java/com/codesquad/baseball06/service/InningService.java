package com.codesquad.baseball06.service;


import com.codesquad.baseball06.model.dao.HalfInningDao;
import com.codesquad.baseball06.model.entity.HalfInning;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InningService {

  private static final Logger log = LoggerFactory.getLogger(InningService.class);
  private final HalfInningDao halfInningDao;

  public InningService(HalfInningDao halfInningDao) {
    this.halfInningDao = halfInningDao;
  }

  public int addHalfInning(HalfInning addedHalfInning) {
    return halfInningDao.create(
        addedHalfInning.getGameId(), addedHalfInning.getIndex(), addedHalfInning.getType());
  }

  public HalfInning getHalfInnning(Long gameId) {
    return halfInningDao.findHalfInningByGameIdAndLast(gameId);
  }
}

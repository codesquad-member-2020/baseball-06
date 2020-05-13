package com.codesquad.baseball06.service;


import com.codesquad.baseball06.model.dao.HalfInningDao;
import com.codesquad.baseball06.model.dao.InningStatusDao;
import com.codesquad.baseball06.model.entity.Batter;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.entity.InningStatus;
import com.codesquad.baseball06.model.entity.Pitcher;
import com.codesquad.baseball06.model.query.InningStatusQuery;
import com.codesquad.baseball06.model.type.BattingResult;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InningService {

  private static final Logger log = LoggerFactory.getLogger(InningService.class);
  private final HalfInningDao halfInningDao;
  private final InningStatusDao inningStatusDao;
  private final PlateAppearanceService paService;

  public InningService(HalfInningDao halfInningDao,
      InningStatusDao inningStatusDao,
      PlateAppearanceService paService) {
    this.halfInningDao = halfInningDao;
    this.inningStatusDao = inningStatusDao;
    this.paService = paService;
  }

  public void addHalfInning(HalfInning halfInning) {
    halfInningDao.addNewHalfInning(
        halfInning.getGameId(),
        halfInning.getIndex(),
        halfInning.getType());

    HalfInning afterDBInsertedHalfInning = getHalfInning(halfInning.getGameId());

    inningStatusDao.createNewInningStatus(afterDBInsertedHalfInning);
//    baseStatusDao.createNewBaseStatus(afterDBInsertedHalfInning.getId());
  }

  public HalfInning getHalfInning(Long gameId) {
    return halfInningDao.findHalfInningByGameIdAndLast(gameId);
  }

  public List<HalfInning> getHalfInningList(Long gameId) {
    return halfInningDao.findHalfInningByGameId(gameId);
  }

  public BattingResult proceedPA(HalfInning halfInning) {
    Pitcher pitcher = Pitcher.create(2L, "Dan");
    Batter batter = Batter.create(1L, "Sigrid", 0.222);
    BattingResult battingResult = paService.doPitching(pitcher, batter);
    BattingResult postBattingResult = paService.postPitching(halfInning, battingResult);

    if (updateInningStatus(halfInning, postBattingResult) == 1) {
      return postBattingResult;
    }

    throw new RuntimeException("데이터베이스에 정상적으로 저장되지 않았습니다.");
  }

  public int updateInningStatus(HalfInning halfInning, BattingResult postBattingResult) {
    return inningStatusDao.updateInningStatus(halfInning, InningStatusQuery.UPDATE);
  }

  public InningStatus getInningStatus(Long gameId) {
    return inningStatusDao.findInningStatusByGameId(gameId);
  }
}

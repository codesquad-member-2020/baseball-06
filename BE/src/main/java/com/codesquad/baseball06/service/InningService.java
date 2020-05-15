package com.codesquad.baseball06.service;


import com.codesquad.baseball06.model.dao.BaseStatusDao;
import com.codesquad.baseball06.model.dao.HalfInningDao;
import com.codesquad.baseball06.model.dao.InningStatusDao;
import com.codesquad.baseball06.model.dao.TeamDao;
import com.codesquad.baseball06.model.entity.BaseStatus;
import com.codesquad.baseball06.model.entity.Batter;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.entity.InningStatus;
import com.codesquad.baseball06.model.entity.Pitcher;
import com.codesquad.baseball06.model.entity.Team;
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
  private final BaseStatusDao baseStatusDao;
  private final TeamDao teamDao;
  private final PlateAppearanceService paService;

  public InningService(HalfInningDao halfInningDao,
      InningStatusDao inningStatusDao,
      BaseStatusDao baseStatusDao,
      TeamDao teamDao, PlateAppearanceService paService) {
    this.halfInningDao = halfInningDao;
    this.inningStatusDao = inningStatusDao;
    this.baseStatusDao = baseStatusDao;
    this.teamDao = teamDao;
    this.paService = paService;
  }

  public HalfInning addHalfInning(HalfInning halfInning) {
    halfInningDao.addNewHalfInning(
        halfInning.getGameId(),
        halfInning.getIndex(),
        halfInning.getType());

    HalfInning afterDBInsertedHalfInning = getHalfInning(halfInning.getGameId());

    inningStatusDao.createNewInningStatus(afterDBInsertedHalfInning);
    baseStatusDao.createNewBaseStatus(afterDBInsertedHalfInning);

    return afterDBInsertedHalfInning;
  }

  public HalfInning getHalfInning(Long gameId) {
    return halfInningDao.findHalfInningByGameIdAndLast(gameId);
  }

  public List<HalfInning> getHalfInningList(Long gameId) {
    return halfInningDao.findHalfInningByGameId(gameId);
  }

  public BattingResult proceedPA(HalfInning halfInning) {
    //TODO: teamDao에서 가져와서 Pitcher와 Batter를 매칭시켜야 하는데, 해당 로직 구현하지 않음
    Pitcher pitcher = Pitcher.create(2L, "Dan");
    Batter batter = Batter.create(1L, "Sigrid", 0.222);
    BattingResult battingResult = paService.doPitching(pitcher, batter);
    BattingResult postBattingResult = paService.postPitching(halfInning, battingResult);

    if (postBattingResult.equals(BattingResult.END)) {
      halfInning.setEnd(true);
    }

    if (postBattingResult.equals(BattingResult.HIT)) {
      updateBaseStatusResult(halfInning);

      halfInning.getInningStatus().newPlateAppearance();
      if (halfInning.getBaseStatus().getThirdBase()) {
        halfInning.addScore();
      }
    }

    halfInningDao.updateHalfInning(halfInning);

    if (updateInningStatus(halfInning, postBattingResult) == 1) {
      return postBattingResult;
    }

    throw new RuntimeException("데이터베이스에 정상적으로 저장되지 않았습니다.");
  }

  public int updateInningStatus(HalfInning halfInning, BattingResult postBattingResult) {
    return inningStatusDao.updateInningStatus(halfInning, InningStatusQuery.UPDATE);
  }

  public void updateBaseStatusResult(HalfInning halfInning) {
    halfInning.updateBases();
    baseStatusDao.updateBaseStatus(halfInning.getId(), halfInning.getBaseStatus());
  }

  public InningStatus getInningStatus(Long gameId) {
    return inningStatusDao.findInningStatusByGameId(gameId);
  }

  public BaseStatus getBaseStatus(Long gameId) {
    return baseStatusDao.findBaseStatusByGameId(gameId);
  }

  public List<Team> getAllTeamInfo(Long gameId) {
    return teamDao.getAllTeamInfoByGameId(gameId);
  }
}

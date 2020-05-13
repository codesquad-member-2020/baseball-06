package com.codesquad.baseball06.service;


import com.codesquad.baseball06.model.dao.HalfInningDao;
import com.codesquad.baseball06.model.dao.InningStatusAndPlateAppearanceUpdateDao;
import com.codesquad.baseball06.model.entity.Batter;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.entity.Pitcher;
import com.codesquad.baseball06.model.type.BattingResult;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InningService {

  private static final Logger log = LoggerFactory.getLogger(InningService.class);
  private final HalfInningDao halfInningDao;
  private final InningStatusAndPlateAppearanceUpdateDao inningStatusAndPlateAppearanceUpdateDao;
  private final PlateAppearanceService paService;

  public InningService(HalfInningDao halfInningDao,
      InningStatusAndPlateAppearanceUpdateDao inningStatusAndPlateAppearanceUpdateDao,
      PlateAppearanceService paService) {
    this.halfInningDao = halfInningDao;
    this.inningStatusAndPlateAppearanceUpdateDao = inningStatusAndPlateAppearanceUpdateDao;
    this.paService = paService;
  }

  public void addHalfInning(HalfInning addedButBeforeInsertedDBHalfInning) {
    halfInningDao.addNewHalfInning(
        addedButBeforeInsertedDBHalfInning.getGameId(),
        addedButBeforeInsertedDBHalfInning.getIndex(),
        addedButBeforeInsertedDBHalfInning.getType());

    HalfInning afterDBInsertedHalfInning = getHalfInning(
        addedButBeforeInsertedDBHalfInning.getGameId());
    inningStatusAndPlateAppearanceUpdateDao.createNewInningStatus(afterDBInsertedHalfInning);
    inningStatusAndPlateAppearanceUpdateDao.createNewBaseStatus(afterDBInsertedHalfInning.getId());
    inningStatusAndPlateAppearanceUpdateDao.createNewPlateAppearance(afterDBInsertedHalfInning);
  }

  public HalfInning getHalfInning(Long gameId) {
    return halfInningDao.findHalfInningByGameIdAndLast(gameId);
  }

  public List<HalfInning> getHalfInningList(Long gameId) {
    return halfInningDao.findHalfInningByGameId(gameId);
  }

  public BattingResult proceedPA(HalfInning halfInning) {
    Batter batter = Batter.create(1L, "Sigrid", 0.222);
    Pitcher pitcher = Pitcher.create(2L, "Dan");
    BattingResult battingResult = paService.doPitching(pitcher, batter);
    return paService.postPitching(halfInning, battingResult);
  }
}

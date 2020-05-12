package com.codesquad.baseball06.service;

import com.codesquad.baseball06.model.dao.InningStatusDao;
import com.codesquad.baseball06.model.entity.Batter;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.entity.Pitcher;
import com.codesquad.baseball06.model.type.BattingResult;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PlateAppearanceService {

  private final InningStatusDao inningStatusDao;

  private static final Logger log = LoggerFactory.getLogger(PlateAppearanceService.class);
  private double delimiter;

  public PlateAppearanceService(InningStatusDao inningStatusDao) {
    this.inningStatusDao = inningStatusDao;
  }

  public BattingResult doPitching(Pitcher pitcher, Batter batter) {
    delimiter = new Random().nextDouble();

    if (isHit(batter)) {
      return BattingResult.HIT;
    }

    if (isStrike(batter)) {
      return BattingResult.STRIKE;
    }

    return BattingResult.BALL;
  }

  public BattingResult postPitching(HalfInning halfInning, BattingResult battingResult) {
    if (battingResult.equals(BattingResult.STRIKE)) {
      BattingResult strikeResult = halfInning.addStrike();
      updatePostPitchingResultToDB(halfInning, battingResult);
      return strikeResult;
    }

    if (battingResult.equals(BattingResult.BALL)) {
      BattingResult ballResult = halfInning.addBall();
      updatePostPitchingResultToDB(halfInning, battingResult);
      return ballResult;
    }

    BattingResult hitResult = BattingResult.HIT;
    updatePostPitchingResultToDB(halfInning, hitResult);
    return hitResult;
  }

  public boolean updatePostPitchingResultToDB(HalfInning halfInning, BattingResult battingResult) {
    if (inningStatusDao.updatePitchingResult(halfInning, battingResult) == 1) {
      return true;
    }
    throw new RuntimeException("데이터베이스에 정상적으로 저장되지 않았습니다.");
  }

  private boolean isHit(Batter batter) {
    return batter.getBattingAverage() > delimiter;
  }

  private boolean isBall(Batter batter) {
    return delimiter - batter.getBattingAverage() > 0.25;
  }

  private boolean isStrike(Batter batter) {
    return delimiter - batter.getBattingAverage() > 0.25;
  }

//  public BattingResult batting(HalfInning halfInning, Pitcher pitcher, Batter batter) {
//    BattingResult battingResult = doPitching(pitcher, batter);
//
//    // pitchingResult 에 따라 후속 로직 추가
//    BattingResult postBattingResult = postPitching(halfInning, battingResult);
//
//    return postBattingResult;
//  }
}

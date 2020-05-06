package com.codesquad.baseball06.service;

import com.codesquad.baseball06.model.Batter;
import com.codesquad.baseball06.model.Inning;
import com.codesquad.baseball06.model.Pitcher;
import com.codesquad.baseball06.model.type.BattingResult;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PlateAppearanceService {

  private static final Logger log = LoggerFactory.getLogger(PlateAppearanceService.class);
  private double delimiter;

  private static void testLogging(Inning inning, BattingResult battingResult,
      BattingResult plateAppearanceResult) {
    log.debug("### {}", battingResult);
    log.debug("### Inning S B O : {}, {}, {}"
        , inning.getStrike(), inning.getBall(), inning.getOut());
    log.debug("### {}", plateAppearanceResult);
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

  public BattingResult postPitching(Inning inning, BattingResult battingResult) {
    if (battingResult.equals(BattingResult.STRIKE)) {
      inning.addStrike();

      if (inning.isOut()) {
        if (inning.isFinished()) {
          testLogging(inning, battingResult, BattingResult.END);
          return BattingResult.END;
        }

        testLogging(inning, battingResult, BattingResult.OUT);
        return BattingResult.OUT;
      }

      testLogging(inning, battingResult, BattingResult.STRIKE);
      return BattingResult.STRIKE;
    } else if (battingResult.equals(BattingResult.BALL)) {
      inning.addBall();

      if (inning.isHit()) {
        testLogging(inning, battingResult, BattingResult.HIT);
        return BattingResult.HIT;
      }

      testLogging(inning, battingResult, BattingResult.BALL);
      return BattingResult.BALL;
    }

    testLogging(inning, battingResult, BattingResult.HIT);
    return BattingResult.HIT;
  }

  private boolean isHit(Batter batter) {
    return batter.getBattingAverage() > delimiter;
  }

  private boolean isBall(Batter batter) {
    return delimiter - batter.getBattingAverage() > 0.4;
  }

  private boolean isStrike(Batter batter) {
    return delimiter - batter.getBattingAverage() > 0.4;
  }

  public BattingResult batting(Inning inning, Pitcher pitcher, Batter batter) {
    BattingResult battingResult = doPitching(pitcher, batter);

    // pitchingResult 에 따라 후속 로직 추가
    BattingResult postBattingResult = postPitching(inning, battingResult);

    return postBattingResult;
  }
}

package com.codesquad.baseball06.model.type;

import com.codesquad.baseball06.model.Batter;
import com.codesquad.baseball06.model.Inning;
import com.codesquad.baseball06.model.Pitcher;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum BattingResult {
  STRIKE("스트라이크"),
  BALL("볼"),
  HIT("안타"),
  OUT("아웃"),
  END("아웃, 공수 전환");

  private static final Logger log = LoggerFactory.getLogger(BattingResult.class);
  private static double delimiter;

  private final String type;

  BattingResult(String type) {
    this.type = type;
  }

  public static BattingResult doPitching(Inning inning, Pitcher pitcher, Batter batter) {
    delimiter = new Random().nextDouble();

    if (isHit(batter)) {
      return BattingResult.HIT;
    }

    if (isStrike(batter)) {
      return BattingResult.STRIKE;
    }

    return BattingResult.BALL;
  }

  public static BattingResult postPitching(Inning inning, BattingResult battingResult) {
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

  private static boolean isHit(Batter batter) {
    return batter.getBattingAverage() > delimiter;
  }

  private static boolean isBall(Batter batter) {
    return delimiter - batter.getBattingAverage() > 0.4;
  }

  private static boolean isStrike(Batter batter) {
    return delimiter - batter.getBattingAverage() > 0.4;
  }

  private static void testLogging(Inning inning, BattingResult battingResult,
      BattingResult plateAppearanceResult) {
    log.debug("### {}", battingResult);
    log.debug("### Inning S B O : {}, {}, {}"
        , inning.getStrikeCount(), inning.getBallCount(), inning.getOutCount());
    log.debug("### {}", plateAppearanceResult);
  }

  public String getType() {
    return type;
  }
}

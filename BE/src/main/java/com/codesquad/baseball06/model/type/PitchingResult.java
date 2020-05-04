package com.codesquad.baseball06.model.type;

import com.codesquad.baseball06.model.Inning;
import com.codesquad.baseball06.model.Player;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum PitchingResult {
  STRIKE("스트라이크"),
  BALL("볼"),
  HIT("안타"),
  OUT("아웃"),
  END("아웃, 공수 전환");

  private static final Logger log = LoggerFactory.getLogger(PitchingResult.class);
  private static double delimiter;

  private final String type;

  PitchingResult(String type) {
    this.type = type;
  }

  public static PitchingResult doPitching(Inning inning, Player pitcher, Player batter) {
    delimiter = new Random().nextDouble();

    if (isHit(batter)) {
      return PitchingResult.HIT;
    }

    if (isStrike(batter)) {
      return PitchingResult.STRIKE;
    }

    return PitchingResult.BALL;
  }

  public static PitchingResult postPitching(Inning inning, PitchingResult pitchingResult) {
    if (pitchingResult.equals(PitchingResult.STRIKE)) {
      inning.addStrike();

      if (inning.isOut()) {
        if (inning.isFinished()) {
          testLogging(inning, pitchingResult, PitchingResult.END);
          return PitchingResult.END;
        }

        testLogging(inning, pitchingResult, PitchingResult.OUT);
        return PitchingResult.OUT;
      }

      testLogging(inning, pitchingResult, PitchingResult.STRIKE);
      return PitchingResult.STRIKE;
    } else if (pitchingResult.equals(PitchingResult.BALL)) {
      inning.addBall();

      if (inning.isHit()) {
        testLogging(inning, pitchingResult, PitchingResult.HIT);
        return PitchingResult.HIT;
      }

      testLogging(inning, pitchingResult, PitchingResult.BALL);
      return PitchingResult.BALL;
    }

    testLogging(inning, pitchingResult, PitchingResult.HIT);
    return PitchingResult.HIT;
  }

  private static boolean isHit(Player batter) {
    return batter.getBattingAverage() > delimiter;
  }

  private static boolean isBall(Player batter) {
    return delimiter - batter.getBattingAverage() > 0.3;
  }

  private static boolean isStrike(Player batter) {
    return batter.getBattingAverage() > delimiter;
  }

  private static void testLogging(Inning inning, PitchingResult pitchingResult,
      PitchingResult plateAppearanceResult) {
    log.debug("### {}", pitchingResult);
    log.debug("### Inning S B O : {}, {}, {}"
        , inning.getStrikeCount(), inning.getBallCount(), inning.getOutCount());
    log.debug("### {}", plateAppearanceResult);
  }

  public String getType() {
    return type;
  }
}

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
      testLogging(PitchingResult.HIT, inning, pitcher, batter);
      return PitchingResult.HIT;
    }

    if (isStrike(batter)) {
      if (inning.getStrikeCount().equals(2)) {
        if (inning.getOutCount().equals(2)) {
          testLogging(PitchingResult.END, inning, pitcher, batter);
          return PitchingResult.END;
        }

        testLogging(PitchingResult.OUT, inning, pitcher, batter);
        return PitchingResult.OUT;
      } else {
        testLogging(PitchingResult.STRIKE, inning, pitcher, batter);
        return PitchingResult.STRIKE;
      }
    }

    if (isBall(batter)) {
      testLogging(PitchingResult.HIT, inning, pitcher, batter);
      return PitchingResult.HIT;
    } else {
      testLogging(PitchingResult.BALL, inning, pitcher, batter);
      return PitchingResult.BALL;
    }
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

  private static void testLogging(PitchingResult pitchingResult, Inning inning, Player pitcher,
      Player batter) {
    log.debug("### {}", pitchingResult);
    log.debug("### Inning S B O : {}, {}, {}"
        , inning.getStrikeCount(), inning.getBallCount(), inning.getOutCount());
    log.debug("### batter.getBattingAverage() : {}", batter.getBattingAverage());
    log.debug("### delimiter : {}", delimiter);
  }

  public String getType() {
    return type;
  }
}

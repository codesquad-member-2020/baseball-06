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
  private final String type;

  PitchingResult(String type) {
    this.type = type;
  }

  public static PitchingResult pitching(Inning inning, Player pitcher, Player batter) {
    double delimiter = new Random().nextDouble();
    PitchingResult pitchingResult;

    if (batter.getBattingAverage() > delimiter) {
      pitchingResult = PitchingResult.HIT;
    } else if (delimiter - batter.getBattingAverage() > 0.3) {
      pitchingResult = PitchingResult.STRIKE;

      if (inning.getStrikeCount().equals(2)) {
        pitchingResult = PitchingResult.OUT;
      }
    } else {
      pitchingResult = PitchingResult.BALL;

      if (inning.getBallCount().equals(3)) {
        pitchingResult = PitchingResult.HIT;
      }
    }

    if (pitchingResult.equals(PitchingResult.OUT) && inning.getOutCount().equals(2)) {
      pitchingResult = PitchingResult.END;
    }

    log.debug("### {}", pitchingResult);
    log.debug("### Inning S B O : {}, {}, {}"
        , inning.getStrikeCount(), inning.getBallCount(), inning.getOutCount());
    log.debug("### batter.getBattingAverage() : {}", batter.getBattingAverage());
    log.debug("### delimiter : {}", delimiter);

    return pitchingResult;
  }

  public String getType() {
    return type;
  }
}

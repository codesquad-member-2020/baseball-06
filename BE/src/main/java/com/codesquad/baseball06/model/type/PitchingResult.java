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

  public static PitchingResult pitching(Inning inning, Player pitcher, Player better) {
    double delimiter = new Random().nextDouble();
    PitchingResult pitchingResult;

    if (better.getBattingAverage() > delimiter) {
      log.debug("### HIT, better.getBattingAverage() : {}", better.getBattingAverage());
      log.debug("### delimiter : {}", delimiter);
      pitchingResult = PitchingResult.HIT;
    } else if (delimiter - better.getBattingAverage() > 0.3) {
      log.debug("### STRIKE, better.getBattingAverage() : {}", better.getBattingAverage());
      log.debug("### delimiter : {}", delimiter);

      pitchingResult = PitchingResult.STRIKE;

      if (inning.getStrikeCount().equals(2)) {
        pitchingResult = PitchingResult.OUT;
      }
    } else {
      log.debug("### BALL, better.getBattingAverage() : {}", better.getBattingAverage());
      log.debug("### delimiter : {}", delimiter);

      pitchingResult = PitchingResult.BALL;

      if (inning.getBallCount().equals(3)) {
        pitchingResult = PitchingResult.OUT;
      }
    }

    if (pitchingResult.equals(PitchingResult.OUT) || inning.getOutCount().equals(2)) {
      pitchingResult = PitchingResult.END;
    }

    return pitchingResult;
  }

  public String getType() {
    return type;
  }
}

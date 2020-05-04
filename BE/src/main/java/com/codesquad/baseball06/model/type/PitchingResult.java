package com.codesquad.baseball06.model.type;

import com.codesquad.baseball06.model.Player;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum PitchingResult {
  STRIKE("스트라이크"),
  BALL("볼"),
  HIT("안타"),
  OUT("아웃");

  private static final Logger log = LoggerFactory.getLogger(PitchingResult.class);
  private final String type;

  PitchingResult(String type) {
    this.type = type;
  }

  public static PitchingResult pitching(Player pitcher, Player better) {
    double delimiter = new Random().nextDouble();

    if (better.getBattingAverage() > delimiter) {
      log.debug("### HIT, better.getBattingAverage() : {}", better.getBattingAverage());
      log.debug("### delimiter : {}", delimiter);
      return PitchingResult.HIT;
    } else if (delimiter - better.getBattingAverage() > 0.3) {
      log.debug("### STRIKE, better.getBattingAverage() : {}", better.getBattingAverage());
      log.debug("### delimiter : {}", delimiter);

      // Inning 상태가 2 STRIKE 인 경우 아웃으로 처리하는 로직 추가

      return PitchingResult.STRIKE;
    } else {
      log.debug("### BALL, better.getBattingAverage() : {}", better.getBattingAverage());
      log.debug("### delimiter : {}", delimiter);

      // Inning 상태가 3 BALL 인 경우 안타로 처리하는 로직 추가

      return PitchingResult.BALL;
    }
  }

  public String getType() {
    return type;
  }
}

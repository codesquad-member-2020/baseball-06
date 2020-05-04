package com.codesquad.baseball06.model.type;

import com.codesquad.baseball06.model.Player;

public enum PitchingResult {
  STRIKE("스트라이크"),
  BALL("볼"),
  HIT("안타"),
  OUT("아웃");

  private final String type;

  PitchingResult(String type) {
    this.type = type;
  }

  public static PitchingResult pitching(Player pitcher, Player better) {
    return PitchingResult.STRIKE;
  }

  public String getType() {
    return type;
  }
}

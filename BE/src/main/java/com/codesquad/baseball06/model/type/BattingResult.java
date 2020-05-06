package com.codesquad.baseball06.model.type;

public enum BattingResult {
  STRIKE("스트라이크"),
  BALL("볼"),
  HIT("안타"),
  OUT("아웃"),
  END("아웃, 공수 전환");

  private final String type;

  BattingResult(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }
}

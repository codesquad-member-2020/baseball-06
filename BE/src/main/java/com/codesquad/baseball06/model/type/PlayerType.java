package com.codesquad.baseball06.model.type;

public enum PlayerType {
  PITCHER(1, "투수"),
  BATTER(2, "타자");

  private final int code;
  private final String type;

  PlayerType(int code, String type) {
    this.code = code;
    this.type = type;
  }

  public String getType() {
    return type;
  }
}

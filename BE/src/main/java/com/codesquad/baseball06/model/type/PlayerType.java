package com.codesquad.baseball06.model.type;

public enum PlayerType {
  PITCHER(0, "투수"),
  BATTER(1, "타자");

  private final int code;
  private final String type;

  PlayerType(int code, String type) {
    this.code = code;
    this.type = type;
  }

  public int getCode() {
    return code;
  }

  public String getType() {
    return type;
  }
}

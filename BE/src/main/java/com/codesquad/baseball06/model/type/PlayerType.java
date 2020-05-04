package com.codesquad.baseball06.model.type;

public enum PlayerType {
  PITCHER("투수"),
  BATTER("타자");

  PlayerType(String type) {
    this.type = type;
  }

  private final String type;

  public String getType() {
    return type;
  }
}

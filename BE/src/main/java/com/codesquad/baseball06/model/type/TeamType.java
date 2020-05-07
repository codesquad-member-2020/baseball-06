package com.codesquad.baseball06.model.type;

public enum TeamType {
  AWAY(0, "원정"),
  HOME(1, "홈");

  private final int code;
  private final String type;

  TeamType(int code, String type) {
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

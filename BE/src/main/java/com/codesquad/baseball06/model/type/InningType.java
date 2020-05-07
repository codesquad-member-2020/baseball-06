package com.codesquad.baseball06.model.type;

public enum InningType {
  EARLY(1, "초"),
  LATE(2, "말");

  private final int code;
  private final String type;

  InningType(int code, String type) {
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

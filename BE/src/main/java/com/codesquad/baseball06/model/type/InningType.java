package com.codesquad.baseball06.model.type;

public enum InningType {
  EARLY("초"),
  LATE("말");

  InningType(String type) {
    this.type = type;
  }

  private final String type;

  public String getType() {
    return type;
  }
}

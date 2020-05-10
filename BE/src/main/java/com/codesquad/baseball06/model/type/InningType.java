package com.codesquad.baseball06.model.type;

public enum InningType {
  EARLY(0, "초"),
  LATE(1, "말");

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

  public static InningType findType(int code) throws Exception {
    for (InningType type: InningType.values()) {
      if (type.code == code) {
        return type;
      }
    }
    throw new Exception("Enum Not Found.");
  }
}

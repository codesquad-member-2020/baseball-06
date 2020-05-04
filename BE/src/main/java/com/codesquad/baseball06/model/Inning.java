package com.codesquad.baseball06.model;

import com.codesquad.baseball06.model.type.InningType;

public class Inning {

  private Long id;
  private Integer score;
  private Integer inningNum;
  private InningType inningType;
  private Integer strikeCount;
  private Integer ballCount;
  private Integer outCount;

  public Long getId() {
    return id;
  }

  public Integer getInningNum() {
    return inningNum;
  }

  public InningType getInningType() {
    return inningType;
  }

  public Integer getStrikeCount() {
    return strikeCount;
  }

  public Integer getBallCount() {
    return ballCount;
  }

  public Integer getOutCount() {
    return outCount;
  }

  public boolean isFinished() {
    return outCount.equals(3);
  }
}
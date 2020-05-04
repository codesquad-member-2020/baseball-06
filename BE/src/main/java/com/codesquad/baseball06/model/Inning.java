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

  private Inning(Integer score, Integer inningNum,
      InningType inningType, Integer strikeCount, Integer ballCount, Integer outCount) {
    this.score = score;
    this.inningNum = inningNum;
    this.inningType = inningType;
    this.strikeCount = strikeCount;
    this.ballCount = ballCount;
    this.outCount = outCount;
  }

  public static Inning create(Integer score, Integer inningNum,
      InningType inningType, Integer strikeCount, Integer ballCount, Integer outCount) {
    return new Inning(score, inningNum,
        inningType, strikeCount, ballCount, outCount);
  }

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

  public boolean isHit() {
    if (ballCount.equals(4)) {
      setNewPlateAppearance();
      return true;
    }

    return false;
  }

  public boolean isOut() {
    if (strikeCount.equals(3)) {
      outCount++;
      setNewPlateAppearance();
      return true;
    }

    return false;
  }

  public boolean isFinished() {
    return outCount.equals(3);
  }

  public void addStrike() {
    strikeCount++;
  }

  public void addBall() {
    ballCount++;
  }

  public void setNewPlateAppearance() {
    ballCount = 0;
    strikeCount = 0;
  }
}

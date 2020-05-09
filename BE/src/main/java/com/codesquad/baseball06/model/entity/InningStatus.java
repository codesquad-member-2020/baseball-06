package com.codesquad.baseball06.model.entity;

import com.codesquad.baseball06.model.type.BattingResult;

public class InningStatus {

  private final Long id;
  private final Long inningId;
  private Integer strike;
  private Integer ball;
  private Integer out;

  public InningStatus(Long id,  Long inningId, Integer strike, Integer ball, Integer out) {
    this.id = id;
    this.inningId = inningId;
    this.strike = strike;
    this.ball = ball;
    this.out = out;
  }

  public static InningStatus create(Long id, Long inningId, Integer strike, Integer ball, Integer out) {
    return new InningStatus(id, inningId, strike, ball, out);
  }

  public Long getId() {
    return id;
  }

  public Integer getStrike() {
    return strike;
  }

  public Integer getBall() {
    return ball;
  }

  public Integer getOut() {
    return out;
  }

  public Long getInningId() {
    return inningId;
  }

  public boolean isHit() {
    return false;
  }

  public boolean isFinished() {
    return out.equals(3);
  }

  public BattingResult addStrike() {
    strike++;

    if (strike.equals(3)) {
      return addOut();
    }

    return BattingResult.STRIKE;
  }

  private BattingResult addOut() {
    out++;
    newPlateAppearance();
    return BattingResult.OUT;
  }

  public BattingResult addBall() {
    ball++;

    if (ball.equals(4)) {
      newPlateAppearance();
      return BattingResult.HIT;
    }
    return BattingResult.BALL;
  }

  public void newPlateAppearance() {
    ball = 0;
    strike = 0;
  }

  public void newInning() {
    newPlateAppearance();
    out = 0;
  }

  public String getStatus() {
    StringBuilder sb = new StringBuilder();
    return sb.append(getStrike()).append("S ")
        .append(getBall()).append("B ")
        .append(getOut()).append("O")
        .toString();
  }
}

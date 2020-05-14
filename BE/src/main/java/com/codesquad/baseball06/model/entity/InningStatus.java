package com.codesquad.baseball06.model.entity;

import com.codesquad.baseball06.model.type.BattingResult;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class InningStatus {

  private final Long id;
  private final Long halfInningId;
  private Integer strike;
  private Integer ball;
  private Integer out;

  public InningStatus(Long id, Long halfInningId, Integer strike, Integer ball, Integer out) {
    this.id = id;
    this.halfInningId = halfInningId;
    this.strike = strike;
    this.ball = ball;
    this.out = out;
  }

  public static InningStatus create(Long id, Long halfInningId, Integer strike, Integer ball,
      Integer out) {
    return new InningStatus(id, halfInningId, strike, ball, out);
  }

  public static InningStatus create(Long halfInningId) {
    return new InningStatus(null, halfInningId, 0, 0, 0);
  }

  public void newPlateAppearance() {
    ball = 0;
    strike = 0;
  }

  public void newInning() {
    newPlateAppearance();
    out = 0;
  }

  @JsonIgnore
  public boolean isHit() {
    return ball.equals(4);
  }

  @JsonIgnore
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

    if (isFinished()) {
      return BattingResult.END;
    }
    return BattingResult.OUT;
  }

  public BattingResult addBall() {
    ball++;

    if (ball.equals(4)) {
      return addHit();
    }
    return BattingResult.BALL;
  }

  @JsonIgnore
  private BattingResult addHit() {
    newPlateAppearance();
    return BattingResult.HIT;
  }

  public String getStatus() {
    StringBuilder sb = new StringBuilder();
    return sb.append(strike).append("S ")
        .append(ball).append("B ")
        .append(out).append("O")
        .toString();
  }

  public Long getId() {
    return id;
  }

  public Long getHalfInningId() {
    return halfInningId;
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
}

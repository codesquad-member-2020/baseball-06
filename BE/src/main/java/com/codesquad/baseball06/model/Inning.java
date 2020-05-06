package com.codesquad.baseball06.model;

import com.codesquad.baseball06.model.type.InningType;

public class Inning {

  private Long id;
  private Integer score;
  private Integer index;
  private InningType type;
  private Integer strike;
  private Integer ball;
  private Integer out;

  private Inning(Integer score, Integer index,
      InningType type, Integer strike, Integer ball, Integer out) {
    this.score = score;
    this.index = index;
    this.type = type;
    this.strike = strike;
    this.ball = ball;
    this.out = out;
  }

  public static Inning create(Integer score, Integer index, InningType type, Integer strike,
      Integer ball, Integer out) {
    return new Inning(score, index,
        type, strike, ball, out);
  }

  public Long getId() {
    return id;
  }

  public Integer getIndex() {
    return index;
  }

  public InningType getType() {
    return type;
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

  public boolean isHit() {
    if (ball.equals(4)) {
      setNewPlateAppearance();
      return true;
    }

    return false;
  }

  public boolean isOut() {
    if (strike.equals(3)) {
      out++;
      setNewPlateAppearance();
      return true;
    }

    return false;
  }

  public boolean isFinished() {
    return out.equals(3);
  }

  public void addStrike() {
    strike++;
  }

  public void addBall() {
    ball++;
  }

  public void setNewPlateAppearance() {
    ball = 0;
    strike = 0;
  }
}

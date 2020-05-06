package com.codesquad.baseball06.model;

import com.codesquad.baseball06.model.type.BattingResult;
import com.codesquad.baseball06.model.type.InningType;

public class Inning {

  private final Long id;
  private final Integer index;
  private final InningType type;
  private Integer score;
  private Integer strike;
  private Integer ball;
  private Integer out;

  private Inning(Long id, Integer score, Integer index,
      InningType type, Integer strike, Integer ball, Integer out) {
    this.id = id;
    this.score = score;
    this.index = index;
    this.type = type;
    this.strike = strike;
    this.ball = ball;
    this.out = out;
  }

  public static Inning create(Long id, Integer score, Integer index, InningType type,
      Integer strike, Integer ball, Integer out) {
    return new Inning(id, score, index, type, strike, ball, out);
  }

  public Long getId() {
    return id;
  }

  public Integer getIndex() {
    return index;
  }

  public Integer getScore() {
    return score;
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
    return false;
  }

  public boolean isFinished() {
    return out.equals(3);
  }

  public int addScore() {
    score++;
    return score;
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

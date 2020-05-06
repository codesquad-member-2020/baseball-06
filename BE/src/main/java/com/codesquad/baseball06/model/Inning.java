package com.codesquad.baseball06.model;

import com.codesquad.baseball06.model.type.BattingResult;
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
    return false;
  }

  public boolean isFinished() {
    return out.equals(3);
  }

  public BattingResult addStrike() {
    strike++;
    return (strike.equals(3)) ? addOut() : BattingResult.STRIKE;
  }

  private BattingResult addOut() {
    out++;
    setNewPlateAppearance();
    return BattingResult.OUT;
  }

  public BattingResult addBall() {
    ball++;

    if (ball.equals(4)) {
      setNewPlateAppearance();
      return BattingResult.HIT;
      // 선수의 hit 수는 기록할 예정
      // 하지만 inning 의 hit 개수가 필요하냐? No
    }
    return BattingResult.BALL;
  }

  public void setNewPlateAppearance() {
    ball = 0;
    strike = 0;
  }
}

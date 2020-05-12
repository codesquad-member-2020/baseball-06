package com.codesquad.baseball06.model.entity;

import com.codesquad.baseball06.model.type.InningType;
import java.time.LocalDateTime;

public class HalfInning {

  private final Long id;
  private final Long gameId;
  private final Integer index;
  private final InningType type;
  private Integer score;
  private Boolean end;
  private InningStatus inningStatus;
  private BaseStatus baseStatus;
  private LocalDateTime createdAt;

  private HalfInning(Long id, Long gameId, Integer index,
      InningType type, Integer score, Boolean end, LocalDateTime createdAt) {
    this.id = id;
    this.gameId = gameId;
    this.index = index;
    this.type = type;
    this.score = score;
    this.end = end;
    this.createdAt = createdAt;
  }

  private HalfInning(Long gameId, Integer index, InningType type) {
    this.id = null;
    this.gameId = gameId;
    this.index = index;
    this.type = type;
    this.score = 0;
    this.end = false;
    this.createdAt = null;
  }

  public static HalfInning create(Long id, Long gameId, Integer index,
      InningType type, Integer score, Boolean end, LocalDateTime createdAt) {
    return new HalfInning(id, gameId, index, type, score, end, createdAt);
  }

  public static HalfInning create(Long gameId, Integer index, InningType type) {
    return new HalfInning(gameId, index, type);
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

  public boolean isHit() {
    return false;
  }

  public Long getGameId() {
    return gameId;
  }

  public Boolean getEnd() {
    return end;
  }

  public InningStatus getInningStatus() {
    return inningStatus;
  }

  public BaseStatus getBaseStatus() {
    return baseStatus;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  //  public boolean isFinished() {
//    return out.equals(3);
//  }

  public int addScore() {
    score++;
    return score;
  }

//  public BattingResult addStrike() {
//    strike++;
//
//    if (strike.equals(3)) {
//      return addOut();
//    }
//
//    return BattingResult.STRIKE;
//  }
//
//  private BattingResult addOut() {
//    out++;
//    newPlateAppearance();
//    return BattingResult.OUT;
//  }
//
//  public BattingResult addBall() {
//    ball++;
//
//    if (ball.equals(4)) {
//      newPlateAppearance();
//      return BattingResult.HIT;
//    }
//    return BattingResult.BALL;
//  }
//
//public void newPlateAppearance() {
//  ball = 0;
//  strike = 0;
//}
//
//  public void newInning() {
//  newPlateAppearance();
//  out = 0;
//}
//
//  public String getStatus() {
//    StringBuilder sb = new StringBuilder();
//    return sb.append(getStrike()).append("S ")
//        .append(getBall()).append("B ")
//        .append(getOut()).append("O")
//        .toString();
//  }
}

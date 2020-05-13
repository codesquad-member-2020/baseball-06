package com.codesquad.baseball06.model.entity;

import com.codesquad.baseball06.model.type.BattingResult;
import com.codesquad.baseball06.model.type.InningType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;

public class HalfInning {

  private final Long id;
  private final Long gameId;
  private final Integer index;
  private final InningType type;
  private Integer score;
  private Boolean end;
  @JsonIgnore
  private InningStatus inningStatus;
  @JsonIgnore
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
    this.inningStatus = InningStatus.create(this.id);
    this.baseStatus = BaseStatus.create(this.id);
  }

  private HalfInning(Long gameId, Integer index, InningType type) {
    this.id = null;
    this.gameId = gameId;
    this.index = index;
    this.type = type;
    this.score = 0;
    this.end = false;
    this.createdAt = null;
    this.inningStatus = InningStatus.create(this.id);
    this.baseStatus = BaseStatus.create(this.id);
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

  @JsonIgnore
  public Boolean isFinished() {
    return inningStatus.isFinished();
  }

  public int addScore() {
    score++;
    return score;
  }

  public BattingResult addStrike() {
    return inningStatus.addStrike();
  }

  public BattingResult addBall() {
    return inningStatus.addBall();
  }
}

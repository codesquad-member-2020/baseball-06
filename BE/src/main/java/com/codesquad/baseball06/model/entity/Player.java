package com.codesquad.baseball06.model.entity;

public abstract class Player {

  private final Long id;
  private final Long teamId;
  private final String name;

  protected Player(Long id, Long teamId, String name) {
    this.id = id;
    this.teamId = teamId;
    this.name = name;
  }

  protected Player(Long teamId, String name) {
    this.id = null;
    this.teamId = teamId;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public Long getTeamId() {
    return teamId;
  }

  public String getName() {
    return name;
  }

  public abstract Double getBattingAverage();

  public abstract Integer getBatterIndex();
}

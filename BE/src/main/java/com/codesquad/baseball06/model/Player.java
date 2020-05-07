package com.codesquad.baseball06.model;

public abstract class Player {

  private final Long id;
  private final Long teamId;
  private final String name;

  public Player(Long id, Long teamId, String name) {
    this.id = id;
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
}

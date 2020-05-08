package com.codesquad.baseball06.model.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Pitcher extends Player {

  private Pitcher(Long id, Long teamId, String name) {
    super(id, teamId, name);
  }

  private Pitcher(Long teamId, String name) {
    super(teamId, name);
  }

  public static Pitcher create(Long id, Long teamId, String name) {
    return new Pitcher(id, teamId, name);
  }

  public static Pitcher create(Long teamId, String name) {
    return new Pitcher(teamId, name);
  }

  @Override
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public Double getBattingAverage() {
    return null;
  }
}

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

  //TODO 조금 더 상속에 대한 개념을 어떻게 적극적으로 사용할 것인가를 질문해보고 싶습니다.. 어려워.

  @Override
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public Double getBattingAverage() {
    return null;
  }

  @Override
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public Integer getBatterIndex() {
    return null;
  }
}

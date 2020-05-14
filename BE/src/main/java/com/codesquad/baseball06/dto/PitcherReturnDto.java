package com.codesquad.baseball06.dto;

public class PitcherReturnDto {
  private Long id;
  private String name;
  private Long team_id;

  private PitcherReturnDto(Long id, String name, Long team_id) {
    this.id = id;
    this.name = name;
    this.team_id = team_id;
  }

  public static PitcherReturnDto create(Long id, String name, Long team_id) {
    return new PitcherReturnDto(id, name, team_id);
  }
}

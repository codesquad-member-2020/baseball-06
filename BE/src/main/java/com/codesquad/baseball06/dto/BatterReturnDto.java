package com.codesquad.baseball06.dto;

public class BatterReturnDto {
  private Long id;
  private String name;
  private double battingAverage;
  private Long team_id;

  private BatterReturnDto(Long id, String name, double battingAverage, Long team_id) {
    this.id = id;
    this.name = name;
    this.battingAverage = battingAverage;
    this.team_id = team_id;
  }

  public static BatterReturnDto create(Long id, String name, double battingAverage, Long team_id) {
    return new BatterReturnDto(id, name, battingAverage, team_id);
  }
}

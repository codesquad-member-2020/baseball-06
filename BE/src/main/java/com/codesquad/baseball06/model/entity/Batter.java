package com.codesquad.baseball06.model.entity;

public class Batter extends Player {

  private final Double battingAverage;

  private Batter(Long id, Long teamId, String name, Double battingAverage) {
    super(id, teamId, name);
    this.battingAverage = battingAverage;
  }

  private Batter(Long teamId, String name, Double battingAverage) {
    super(teamId, name);
    this.battingAverage = battingAverage;
  }

  public static Batter create(Long id, Long teamId, String name, Double battingAverage) {
    return new Batter(id, teamId, name, battingAverage);
  }

  public static Batter create(Long teamId, String name, Double battingAverage) {
    return new Batter(teamId, name, battingAverage);
  }

  @Override
  public Double getBattingAverage() {
    return battingAverage;
  }
}

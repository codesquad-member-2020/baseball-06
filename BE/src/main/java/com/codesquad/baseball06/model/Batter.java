package com.codesquad.baseball06.model;

public class Batter extends Player {

  private final Double battingAverage;

  private Batter(Long id, String name, Double battingAverage) {
    super(id, name);
    this.battingAverage = battingAverage;
  }

  public static Batter create(Long id, String name, Double battingAverage) {
    return new Batter(id, name, battingAverage);
  }

  @Override
  public Double getBattingAverage() {
    return battingAverage;
  }
}

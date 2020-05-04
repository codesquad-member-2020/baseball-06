package com.codesquad.baseball06.model;

import com.codesquad.baseball06.model.type.PlayerType;

public class Player {
  private Long id;
  private String name;
  private PlayerType type;
  private Long battingAverage;

  private Player(Long id, String name, PlayerType type, Long battingAverage) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.battingAverage = battingAverage;
  }

  private Player(String name, PlayerType type, Long battingAverage) {
    this.name = name;
    this.type = type;
    this.battingAverage = battingAverage;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public PlayerType getType() {
    return type;
  }

  public Long getBattingAverage() {
    return battingAverage;
  }

  public static Player create(Long id, String name, PlayerType type, Long battingAverage) {
    return new Player(id, name, type, battingAverage);
  }

  public static Player create(String name, PlayerType type, Long battingAverage) {
    return new Player(name, type, battingAverage);
  }
}

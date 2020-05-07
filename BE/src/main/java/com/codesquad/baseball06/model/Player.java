package com.codesquad.baseball06.model;

public abstract class Player {

  private final Long id;
  private final String name;

  public Player(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public abstract Double getBattingAverage();
}

package com.codesquad.baseball06.model;

public class Pitcher extends Player {

  private Pitcher(Long id, String name) {
    super(id, name);
  }

  public static Pitcher create(Long id, String name) {
    return new Pitcher(id, name);
  }

  @Override
  public Double getBattingAverage() {
    return null;
  }
}

package com.codesquad.baseball06.model;

public class Pitcher extends Player {

  private Pitcher(Long id, String name) {
    super(id, name);
  }

  private Pitcher(String name) {
    super(name);
  }

  public static Pitcher create(Long id, String name) {
    return new Pitcher(id, name);
  }

  public static Pitcher create(String name) {
    return new Pitcher(name);
  }

  @Override
  public Double getBattingAverage() throws Exception {
    throw new Exception();
  }
}

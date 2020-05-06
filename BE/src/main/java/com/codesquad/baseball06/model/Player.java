package com.codesquad.baseball06.model;

public class Player {

  private Long id;
  private String name;

  public Player(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Player(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}

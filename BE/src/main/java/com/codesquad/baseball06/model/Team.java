package com.codesquad.baseball06.model;

import java.util.List;

public class Team {
  private Long id;
  private String name;
  private List<Player> players;

  private Team(Long id, String name, List<Player> players) {
    this.id = id;
    this.name = name;
    this.players = players;
  }

  private Team(String name, List<Player> players) {
    this.name = name;
    this.players = players;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public static Team create(Long id, String name, List<Player> players) {
    return new Team(id, name, players);
  }

  public static Team create(String name, List<Player> players) {
    return new Team(name, players);
  }
}

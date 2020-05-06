package com.codesquad.baseball06.model;

import java.util.List;

public class Team {

  private final Long id;
  private final String name;
  private final List<Pitcher> pitcherList;
  private final List<Batter> batterList;

  private Team(Long id, String name, List<Pitcher> pitcherList, List<Batter> batterList) {
    this.id = id;
    this.name = name;
    this.pitcherList = pitcherList;
    this.batterList = batterList;
  }

  public static Team create(Long id, String name, List<Pitcher> pitcherList,
      List<Batter> batterList) {
    return new Team(id, name, pitcherList, batterList);
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Pitcher> getPitcherList() {
    return pitcherList;
  }

  public List<Batter> getBatterList() {
    return batterList;
  }
}

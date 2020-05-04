package com.codesquad.baseball06.model;

import java.util.List;

public class Game {

  private Long id;
  private List<Team> team;
  private List<Integer> battingOrderIndex;
  private List<Inning> inningList;
  private List<Integer> totalScore;

  public Long getId() {
    return id;
  }

  public List<Integer> getTotalScore() {
    return totalScore;
  }

  public List<Integer> getBattingOrderIndex() {
    return battingOrderIndex;
  }

  public List<Inning> getInningList() {
    return inningList;
  }

  public List<Team> getTeam() {
    return team;
  }
}

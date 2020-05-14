package com.codesquad.baseball06.dto;

import com.codesquad.baseball06.model.entity.Batter;
import com.codesquad.baseball06.model.entity.Pitcher;
import com.codesquad.baseball06.model.entity.Team;
import java.util.List;

public class TeamReturnDto {

  private final Long id;
  private final String name;
  private final List<Pitcher> pitcherList;
  private final List<Batter> batterList;

  private TeamReturnDto(Team team) {
    this.id = team.getId();
    this.name = team.getName();
    this.pitcherList = team.getPitcherList();
    this.batterList = team.getBatterList();
  }

  public static TeamReturnDto create(Team team) {
    return new TeamReturnDto(team);
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

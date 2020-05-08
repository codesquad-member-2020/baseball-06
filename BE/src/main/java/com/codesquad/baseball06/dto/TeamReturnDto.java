package com.codesquad.baseball06.dto;

import com.codesquad.baseball06.model.Batter;
import com.codesquad.baseball06.model.Pitcher;
import com.codesquad.baseball06.model.Team;
import java.util.List;

public class TeamReturnDto {

  private final Long id;
  private final String name;
  private final List<Pitcher> pitcherList;
  private final List<Batter> batterList;

  private TeamReturnDto(Long id, String name, List<Pitcher> pitcherList, List<Batter> batterList) {
    this.id = id;
    this.name = name;
    this.pitcherList = pitcherList;
    this.batterList = batterList;
  }

  public static TeamReturnDto create(Long id, String name, List<Pitcher> pitcherList,
      List<Batter> batterList) {
    return new TeamReturnDto(id, name, pitcherList, batterList);
  }
}

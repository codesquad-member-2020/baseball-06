package com.codesquad.baseball06.dto.unused;

import com.codesquad.baseball06.model.entity.Batter;
import com.codesquad.baseball06.model.entity.Pitcher;
import com.codesquad.baseball06.model.type.PlayerType;

public class UpdatedPlayerDto {

  private Long id;
  private String name;
  private PlayerType type;
  private Long teamId;
  private Double battingAverage;

  private UpdatedPlayerDto(Long id, String name, PlayerType type, Long teamId) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.teamId = teamId;
  }

  private UpdatedPlayerDto(Long id, String name, PlayerType type, Long teamId,
      Double battingAverage) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.teamId = teamId;
    this.battingAverage = battingAverage;
  }

  public static UpdatedPlayerDto createUpdatedBatterDto(Batter batter) {
    return new UpdatedPlayerDto(batter.getId(), batter.getName(), PlayerType.BATTER,
        batter.getTeamId(), batter.getBattingAverage());
  }

  public static UpdatedPlayerDto createUpdatedPitcherDto(Pitcher pitcher) {
    return new UpdatedPlayerDto(pitcher.getId(), pitcher.getName(), PlayerType.PITCHER,
        pitcher.getTeamId());
  }
}

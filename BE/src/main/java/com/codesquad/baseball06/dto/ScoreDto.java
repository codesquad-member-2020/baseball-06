package com.codesquad.baseball06.dto;

import com.codesquad.baseball06.model.type.InningType;

public class ScoreDto {
  private Integer homeScore;
  private Integer awayScore;
  private Integer inningIndex;
  private InningType inningType;

  private ScoreDto(Integer homeScore, Integer awayScore, Integer inningIndex,
      InningType inningType) {
    this.homeScore = homeScore;
    this.awayScore = awayScore;
    this.inningIndex = inningIndex;
    this.inningType = inningType;
  }

  public Integer getHomeScore() {
    return homeScore;
  }

  public Integer getAwayScore() {
    return awayScore;
  }

  public Integer getInningIndex() {
    return inningIndex;
  }

  public InningType getInningType() {
    return inningType;
  }

  public static ScoreDto create(Integer homeScore, Integer awayScore, Integer inningIndex, InningType inningType) {
    return new ScoreDto(homeScore, awayScore, inningIndex, inningType);
  }
}

package com.codesquad.baseball06.dto;

import java.util.List;
import java.util.Map;

public class InningStatusDto {

  private Map<String, Object> inningStatus;
  private List<UpdatedBasemanDto> updatedBaseman;
  private Map<String, Integer> updatedScore;
  private List<UpdatedPlayerDto> updatedPlayer;

  private InningStatusDto(Map<String, Object> inningStatus,
      List<UpdatedBasemanDto> updatedBaseman,
      Map<String, Integer> updatedScore,
      List<UpdatedPlayerDto> updatedPlayer) {
    this.inningStatus = inningStatus;
    this.updatedBaseman = updatedBaseman;
    this.updatedScore = updatedScore;
    this.updatedPlayer = updatedPlayer;
  }

  public static InningStatusDto create(Map<String, Object> inningStatus,
      List<UpdatedBasemanDto> updatedBaseman,
      Map<String, Integer> updatedScore,
      List<UpdatedPlayerDto> updatedPlayer) {
    return new InningStatusDto(inningStatus, updatedBaseman, updatedScore, updatedPlayer);
  }
}

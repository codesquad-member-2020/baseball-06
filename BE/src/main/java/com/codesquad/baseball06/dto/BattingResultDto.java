package com.codesquad.baseball06.dto;

import com.codesquad.baseball06.model.type.BattingResult;

public class BattingResultDto {

  private BattingResult battingResult;

  private BattingResultDto(BattingResult battingResult) {
    this.battingResult = battingResult;
  }

  public static BattingResultDto create(BattingResult battingResult) {
    return new BattingResultDto(battingResult);
  }
}

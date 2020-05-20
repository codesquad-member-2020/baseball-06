package com.codesquad.baseball06.dto;

import com.codesquad.baseball06.model.type.BattingResult;

public class BattingResultReturnDto {

  private BattingResult battingResult;

  private BattingResultReturnDto(BattingResult battingResult) {
    this.battingResult = battingResult;
  }

  public static BattingResultReturnDto create(BattingResult battingResult) {
    return new BattingResultReturnDto(battingResult);
  }

  public BattingResult getBattingResult() {
    return battingResult;
  }
}

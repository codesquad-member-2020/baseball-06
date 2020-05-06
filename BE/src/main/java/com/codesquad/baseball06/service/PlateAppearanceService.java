package com.codesquad.baseball06.service;

import com.codesquad.baseball06.model.Batter;
import com.codesquad.baseball06.model.Inning;
import com.codesquad.baseball06.model.Pitcher;
import com.codesquad.baseball06.model.type.BattingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PlateAppearanceService {

  private static final Logger log = LoggerFactory.getLogger(PlateAppearanceService.class);

  public BattingResult batting(Inning inning, Pitcher pitcher, Batter batter) {
    BattingResult battingResult = BattingResult.doPitching(inning, pitcher, batter);

    // pitchingResult 에 따라 후속 로직 추가
    return BattingResult.postPitching(inning, battingResult);
  }
}

package com.codesquad.baseball06.service;

import com.codesquad.baseball06.model.Inning;
import com.codesquad.baseball06.model.Player;
import com.codesquad.baseball06.model.type.PitchingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

  private static final Logger log = LoggerFactory.getLogger(PlayerService.class);

  public PitchingResult batting(Inning inning, Player pitcher, Player batter) {
    PitchingResult pitchingResult = PitchingResult.doPitching(inning, pitcher, batter);

    // pitchingResult 에 따라 후속 로직 추가
    return PitchingResult.postPitching(inning, pitchingResult);
  }
}

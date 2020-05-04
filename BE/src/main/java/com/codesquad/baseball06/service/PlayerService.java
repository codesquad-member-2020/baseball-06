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

  public PitchingResult betting(Inning inning, Player pitcher, Player better) {
    PitchingResult pitchingResult = PitchingResult.pitching(inning, pitcher, better);

    // pitchingResult 에 따라 후속 로직 추가

    return pitchingResult;
  }
}

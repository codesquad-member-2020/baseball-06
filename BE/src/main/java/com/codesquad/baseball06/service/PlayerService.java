package com.codesquad.baseball06.service;

import com.codesquad.baseball06.model.Player;
import com.codesquad.baseball06.model.type.PitchingResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

  private static final Logger log = LoggerFactory.getLogger(PlayerService.class);

  public PitchingResult betting(Player pitcher, Player better) {
    return PitchingResult.pitching(pitcher, better);
  }
}

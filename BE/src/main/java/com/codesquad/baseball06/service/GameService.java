package com.codesquad.baseball06.service;

import com.codesquad.baseball06.model.entity.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GameService {

  private static final Logger log = LoggerFactory.getLogger(InningService.class);

  public int start(Game game) {
    if (game.isStartPossible()) {
      return game.addHalfInning();
    }

    throw new RuntimeException("시작할 수 없는 Game 입니다");
  }
}

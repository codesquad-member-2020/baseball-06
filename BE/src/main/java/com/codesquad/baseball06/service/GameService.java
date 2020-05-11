package com.codesquad.baseball06.service;

import com.codesquad.baseball06.model.dao.GameDao;
import com.codesquad.baseball06.model.entity.Game;
import com.codesquad.baseball06.model.entity.User;
import com.codesquad.baseball06.model.type.TeamType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GameService {

  private static final Logger log = LoggerFactory.getLogger(InningService.class);

  private final GameDao gameDao;

  public GameService(GameDao gameDao) {
    this.gameDao = gameDao;
  }

  public int start(Game game) {
    if (game.isStartPossible()) {
      return game.addHalfInning();
    }

    throw new RuntimeException("시작할 수 없는 Game 입니다");
  }

  public Game getGame(Long gameId) {
    return gameDao.findGameById(gameId);
  }

  public User joinUser(Game game, TeamType teamType, User user) {
    return game.updateUser(teamType, user);
  }
}

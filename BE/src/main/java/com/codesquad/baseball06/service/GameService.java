package com.codesquad.baseball06.service;

import com.codesquad.baseball06.model.dao.GameDao;
import com.codesquad.baseball06.model.entity.Game;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.entity.User;
import com.codesquad.baseball06.model.type.TeamType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GameService {

  private static final Logger log = LoggerFactory.getLogger(InningService.class);

  private final GameDao gameDao;
  private final InningService inningService;

  public GameService(GameDao gameDao, InningService inningService) {
    this.gameDao = gameDao;
    this.inningService = inningService;
  }

  public HalfInning start(Game game) {
    if (game.isStartPossible()) {
      if (game.isNewGame()) {
        HalfInning addedHalfInning = game.addHalfInning();
        inningService.addHalfInning(addedHalfInning);

        return inningService.getHalfInnning(addedHalfInning.getGameId());
      }
      return game.getRunningHalfInning();
    }

    throw new RuntimeException("시작할 수 없는 GameQuery 입니다");
  }

  public Game getGame(Long gameId) {
    return gameDao.findGameById(gameId);
  }

  public User joinUser(Game game, TeamType teamType, User user) {
    if (game.updateUser(teamType, user).equals(user)) {
      int result = gameDao.join(game.getId(), user, teamType);
      log.debug("### joinUser : {}", result);
      return user;
    }

    throw new RuntimeException("Failed joinUser");
  }
}

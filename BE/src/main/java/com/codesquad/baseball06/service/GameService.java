package com.codesquad.baseball06.service;

import com.codesquad.baseball06.model.dao.GameDao;
import com.codesquad.baseball06.model.entity.Game;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.entity.User;
import com.codesquad.baseball06.model.type.BattingResult;
import com.codesquad.baseball06.model.type.InningType;
import com.codesquad.baseball06.model.type.TeamType;
import com.codesquad.baseball06.utils.TokenUtil;
import com.google.common.collect.Iterables;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
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

        return inningService.getHalfInning(addedHalfInning.getGameId());
      }

      throw new RuntimeException("이미 게임이 시작되었습니다.");
    }

    throw new RuntimeException("유저가 아직 참여하지 않았습니다.");
  }

  public BattingResult proceed(Game game) {
    if (!game.isEndGame()) {
      TeamType addHalfInningType = checkAddNewHalfInning(game);

      if (Objects.nonNull(addHalfInningType)) {
        if (addHalfInningType.equals(TeamType.AWAY)) {
          inningService.addHalfInning(HalfInning.create(
              game.getId(), game.getEarlyInningList().size() + 1, InningType.EARLY));
        } else {
          inningService.addHalfInning(HalfInning.create(
              game.getId(), game.getLateInningList().size() + 1, InningType.LATE));
        }
      }

      game = getGame(game.getId());

      if (!Iterables.getLast(game.getEarlyInningList()).getEnd()) {
        return inningService.proceedPA(Iterables.getLast(game.getEarlyInningList()));
      }

      if (!Iterables.getLast(game.getLateInningList()).getEnd()) {
        return inningService.proceedPA(Iterables.getLast(game.getLateInningList()));
      }
    }
    throw new RuntimeException("투구를 진행할 수 없는 게임입니다.");
  }

  public TeamType checkAddNewHalfInning(Game game) {
    if (game.getEarlyInningList().size() == 0 && game.getLateInningList().size() == 0) {
      return TeamType.AWAY;
    }

    if (Iterables.getLast(game.getEarlyInningList()).getEnd()
        && game.getLateInningList().size() == 0) {
      return TeamType.HOME;
    }

    if (game.getEarlyInningList().size() == game.getLateInningList().size()) {
      if (Iterables.getLast(game.getLateInningList()).getEnd()) {
        return TeamType.AWAY;
      }
    }

    if (game.getEarlyInningList().size() > game.getLateInningList().size()) {
      if (Iterables.getLast(game.getEarlyInningList()).getEnd()) {
        return TeamType.HOME;
      }
    }

    return null;
  }

  public Game getGame(Long gameId) {
    Game game = gameDao.findGameById(gameId);

    List<HalfInning> halfInningList = inningService.getHalfInningList(gameId);
    List<HalfInning> earlyInningList = halfInningList.stream()
        .filter(halfInning -> halfInning.getType().equals(InningType.EARLY))
        .collect(Collectors.toList());
    List<HalfInning> lateInningList = halfInningList.stream()
        .filter(halfInning -> halfInning.getType().equals(InningType.LATE)).collect(
            Collectors.toList());

    game.setEarlyInningList(earlyInningList);
    game.setLateInningList(lateInningList);

    return game;
  }

  public Game joinUser(Game game, TeamType teamType, String jwt) {
    User user = User.create(TokenUtil.getUserEmail(jwt));

    if (game.updateUser(teamType, user).equals(user)) {
      Game findGame = gameDao.findGameById(game.getId());

      if (Objects.isNull(findGame.getUsers().get(teamType))) {
        gameDao.join(game.getId(), user, teamType);
        return gameDao.findGameById(game.getId());
      } else {
        throw new RuntimeException("Already user joined");
      }
    }

    throw new RuntimeException("Failed joinUser");
  }
}

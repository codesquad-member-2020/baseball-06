package com.codesquad.baseball06.service;

import com.codesquad.baseball06.model.dao.GameDao;
import com.codesquad.baseball06.model.entity.Game;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.entity.User;
import com.codesquad.baseball06.model.type.BattingResult;
import com.codesquad.baseball06.model.type.InningType;
import com.codesquad.baseball06.model.type.TeamType;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;
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

        ArrayList<HalfInning> listAfterIdSetOfAddedHalfInning = new ArrayList<>();
        listAfterIdSetOfAddedHalfInning
            .add(inningService.getHalfInnning(addedHalfInning.getGameId()));
        game.setEarlyInningList(listAfterIdSetOfAddedHalfInning);

        return inningService.getHalfInnning(addedHalfInning.getGameId());
      }
      throw new RuntimeException("이미 게임이 시작되었습니다.");
    }

    throw new RuntimeException("유저가 아직 참여하지 않았습니다.");
  }

  public BattingResult proceed(Game game) {

    if (!game.isNewGame() && !game.isEndGame()) {
      checkAddNewHalfInningBeforeProceed(game);
      if (!Iterables.getLast(game.getEarlyInningList()).getEnd()) {
        return inningService.proceedPA(Iterables.getLast(game.getEarlyInningList()));
      }

      if (!Iterables.getLast(game.getLateInningList()).getEnd()) {
        return inningService.proceedPA(Iterables.getLast(game.getLateInningList()));
      }
    }
    throw new RuntimeException("투구를 진행할 수 없는 게임입니다.");
  }

  public void checkAddNewHalfInningBeforeProceed(Game game) {
    if (Iterables.getLast(game.getEarlyInningList()).getEnd() &&
        Iterables.getLast(game.getLateInningList()).getEnd()) {

      if (game.getEarlyInningList().size() == game.getLateInningList().size()) {
        inningService.addHalfInning(HalfInning.create(
            game.getId(),
            game.getEarlyInningList().size() + 1,
            InningType.EARLY)
        );
      }
      ;

      if (game.getEarlyInningList().size() != game.getLateInningList().size()) {
        inningService.addHalfInning(HalfInning.create(
            game.getId(),
            game.getLateInningList().size() + 1,
            InningType.LATE)
        );
      }
    }
  }

  public Game getGame(Long gameId) {
    Game game = gameDao.findGameById(gameId);

    List<HalfInning> halfInningList = inningService.getHalfInnningList(gameId);
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

  public User joinUser(Game game, TeamType teamType, User user) {
    if (game.updateUser(teamType, user).equals(user)) {
      int result = gameDao.join(game.getId(), user, teamType);
      return user;
    }

    throw new RuntimeException("Failed joinUser");
  }
}

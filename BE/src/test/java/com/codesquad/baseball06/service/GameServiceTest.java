package com.codesquad.baseball06.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.codesquad.baseball06.model.dao.GameDao;
import com.codesquad.baseball06.model.dao.TeamDao;
import com.codesquad.baseball06.model.entity.Game;
import com.codesquad.baseball06.model.entity.User;
import com.codesquad.baseball06.model.type.TeamType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GameServiceTest {

  @Autowired
  GameService gameService;

  @Autowired
  GameDao gameDao;

  @Autowired
  TeamDao teamDao;

  @Test
  void start_null() {
    gameDao.create(teamDao.findTeamById(3L), teamDao.findTeamById(4L));
    Game game = gameDao.findGameById(2L);

    assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(() -> gameService.start(game));
  }

  @Test
  void start_joined() {
    gameDao.create(teamDao.findTeamById(3L), teamDao.findTeamById(4L));

    User awayUser = User.create("away email11");
    User homeUser = User.create("home email11");
    gameDao.join(2L, awayUser, TeamType.AWAY);
    gameDao.join(2L, homeUser, TeamType.HOME);

    Game game = gameDao.findGameById(2L);

//    assertThat(gameService.start(game))
//        .isGreaterThanOrEqualTo(1);
  }
}

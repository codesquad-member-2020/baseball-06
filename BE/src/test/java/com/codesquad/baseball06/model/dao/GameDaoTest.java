package com.codesquad.baseball06.model.dao;

import com.codesquad.baseball06.model.entity.Team;
import com.codesquad.baseball06.model.entity.User;
import com.codesquad.baseball06.model.type.TeamType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GameDaoTest {

  @Autowired
  private TeamDao teamDao;

  @Autowired
  private GameDao gameDao;

  @Test
  void create() {
    Team away = teamDao.findTeamById(4L);
    Team home = teamDao.findTeamById(2L);

    Assertions.assertThat(gameDao.create(away, home))
        .isOne();
  }

  @Test
  void join_away() {
    User awayUser = User.create("away email11");

    gameDao.join(2L, awayUser, TeamType.AWAY);
  }

  @Test
  void join_home() {
    User homeUser = User.create("home email11");

    gameDao.join(2L, homeUser, TeamType.HOME);
  }
}

package com.codesquad.baseball06.model.dao;

import com.codesquad.baseball06.model.entity.Team;
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
  void createGame() {
    Team away = teamDao.findTeamById(4L);
    Team home = teamDao.findTeamById(2L);

    Assertions.assertThat(gameDao.createGame(away, home))
        .isOne();
  }
}

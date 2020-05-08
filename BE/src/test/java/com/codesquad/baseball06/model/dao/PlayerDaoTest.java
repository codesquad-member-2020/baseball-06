package com.codesquad.baseball06.model.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.codesquad.baseball06.model.entity.Batter;
import com.codesquad.baseball06.model.entity.Pitcher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlayerDaoTest {

  @Autowired
  private PlayerDao playerDao;

  @Test
  void findPlayerById_pitcher() {
    assertThat(playerDao.findPlayerById(1L).get())
        .isNotNull()
        .isInstanceOf(Pitcher.class);
  }

  @Test
  void findPlayerById_batter() {
    assertThat(playerDao.findPlayerById(3L).get())
        .isNotNull()
        .isInstanceOf(Batter.class);
  }
}

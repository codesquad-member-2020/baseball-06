package com.codesquad.baseball06.model.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.codesquad.baseball06.model.entity.Batter;
import com.codesquad.baseball06.model.entity.Pitcher;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlayerDaoTest {

  private static final Logger log = LoggerFactory.getLogger(PlayerDaoTest.class);

  @Autowired
  private PlayerDao playerDao;

  @Test
  void findPlayerById_pitcher() {
    assertThat(playerDao.findPitcherById(1L).get())
        .isNotNull()
        .isInstanceOf(Pitcher.class);
  }

  @Test
  void findPlayerById_batter() {
    assertThat(playerDao.findBatterById(3L).get())
        .isNotNull()
        .isInstanceOf(Batter.class);
  }

  @Test
  void findPitchers() {
    assertThat(playerDao.findPitchers())
        .isNotNull()
        .isInstanceOf(Pitcher.class);
  }

//  @Test
//  void findBatters() {
//    assertThat(playerDao.findBatters())
//        .isNotNull()
//        .isInstanceOf(Batter.class);
//  }
}

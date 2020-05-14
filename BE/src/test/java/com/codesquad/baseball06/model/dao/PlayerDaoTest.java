package com.codesquad.baseball06.model.dao;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.codesquad.baseball06.model.dao.mapper.PlayerDao;
import com.codesquad.baseball06.model.entity.Batter;
import com.codesquad.baseball06.model.entity.Pitcher;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

@SpringBootTest
class PlayerDaoTest {

  private static final Logger log = LoggerFactory.getLogger(PlayerDaoTest.class);

  @Autowired
  private PlayerDao playerDao;

  @Test
  void findPlayerById_pitcher() {
    assertThat(playerDao.findPitcherById(1L))
        .isNotNull()
        .isInstanceOf(Pitcher.class);
  }

  @Test
  void findPlayerById_null() {
    assertThatExceptionOfType(EmptyResultDataAccessException.class)
        .isThrownBy(() -> playerDao.findPitcherById(999L));
  }

  @Test
  void findPlayerById_batter() {
    assertThat(playerDao.findBatterById(3L))
        .isNotNull()
        .isInstanceOf(Batter.class);
  }

  @Test
  void findPitchers() {
    assertThat(playerDao.findPitcherByTeamId(3L))
        .isNotNull()
        .isInstanceOf(ArrayList.class)
        .hasSizeGreaterThan(1);
  }

  @Test
  void findBatters() {
    assertThat(playerDao.findBatterByTeamId(3L))
        .isNotNull()
        .isInstanceOf(ArrayList.class)
        .hasSizeGreaterThan(1);
  }
}

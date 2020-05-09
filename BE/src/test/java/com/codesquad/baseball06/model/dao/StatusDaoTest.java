package com.codesquad.baseball06.model.dao;

import com.codesquad.baseball06.dto.BatterReturnDto;
import com.codesquad.baseball06.dto.InningStatusDto;
import com.codesquad.baseball06.dto.PitcherReturnDto;
import com.codesquad.baseball06.dto.UpdatedBasemanDto;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
class StatusDaoTest {
  private static final Logger log = LoggerFactory.getLogger(StatusDaoTest.class);

  @Autowired
  private StatusDao statusDao;

  @Test
  void INNING_STATUS가_리턴된다() {
    statusDao.InitForTest();
    assertThat(statusDao.getInningStatus())
        .isNotNull()
        .isInstanceOf(InningStatusDto.class);
  }

  @Test
  void UPDATED_BASEMAN이_리턴된다() {
    statusDao.InitForTest();
    assertThat(statusDao.getUpdatedBaseman())
        .isNotNull()
        .isInstanceOf(UpdatedBasemanDto.class);
  }

  @Test
  void UPDATED_SCORE가_리턴된다() {
    statusDao.InitForTest();
    assertThat(statusDao.getHomeScore())
        .isNotNull();
    assertThat(statusDao.getAwayScore())
        .isNotNull();
  }

  @Test
  void UPDATED_PLAYER가_리턴된다() {
    statusDao.InitForTest();
    assertThat(statusDao.getUpdatedPitcher())
        .isNotNull()
        .isInstanceOf(PitcherReturnDto.class);

    assertThat(statusDao.getUpdatedBatter())
        .isNotNull()
        .isInstanceOf(BatterReturnDto.class);
  }
}

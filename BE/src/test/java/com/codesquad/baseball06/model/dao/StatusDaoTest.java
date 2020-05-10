package com.codesquad.baseball06.model.dao;

import com.codesquad.baseball06.dto.UpdatedBasemanDto;
import com.codesquad.baseball06.model.entity.InningStatus;
import com.codesquad.baseball06.model.type.InningType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

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
        .isInstanceOf(InningStatus.class);
  }

  @Test
  void UPDATED_BASEMAN이_리턴된다() {
    statusDao.InitForTest();
    assertThat(statusDao.getUpdatedBaseman())
        .isNotNull()
        .isInstanceOf(UpdatedBasemanDto.class);
  }

  @ParameterizedTest
  @ValueSource(longs = {1L})
  void UPDATED_SCORE가_리턴된다(Long game_id) throws Exception {
    statusDao.InitForTest();
    assertThat(statusDao.getScores(game_id).getAwayScore()).isEqualTo(2);
    assertThat(statusDao.getScores(game_id).getHomeScore()).isEqualTo(3);
    assertThat(statusDao.getScores(game_id).getInningIndex()).isEqualTo(1);
    assertThat(statusDao.getScores(game_id).getInningType()).isEqualTo(InningType.LATE);
  }
//
//  @Test
//  void UPDATED_PLAYER가_리턴된다() {
//    statusDao.InitForTest();
//    assertThat(statusDao.getUpdatedPitcher())
//        .isNotNull()
//        .isInstanceOf(PitcherReturnDto.class);
//
//    assertThat(statusDao.getUpdatedBatter())
//        .isNotNull()
//        .isInstanceOf(BatterReturnDto.class);
//  }
}

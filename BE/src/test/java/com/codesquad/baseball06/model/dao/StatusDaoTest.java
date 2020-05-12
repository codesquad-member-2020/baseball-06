package com.codesquad.baseball06.model.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.codesquad.baseball06.dto.UpdatedBasemanDto;
import com.codesquad.baseball06.model.entity.InningStatus;
import com.codesquad.baseball06.model.type.InningType;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StatusDaoTest {

  private static final Logger log = LoggerFactory.getLogger(StatusDaoTest.class);

  @Autowired
  private StatusDao statusDao;

  @DisplayName("테스트를 수행하기 이전에 테스트에 필요한 정보를 DB에 저장하는 역할을 한다.")
  @BeforeEach
  void init() {
    statusDao.InitForTest();
  }

  @DisplayName("현재 이닝 정보가 정상적으로 리턴되는지 확인한다.")
  @Test
  void INNING_STATUS가_리턴된다() {
    assertThat(statusDao.getInningStatus())
        .isNotNull()
        .isInstanceOf(InningStatus.class);
  }

  @DisplayName("현재 1루수, 2루수, 3루수 정보가 정상적으로 리턴되는지 확인한다.")
  @Test
  void UPDATED_BASEMAN이_리턴된다() {
    assertThat(statusDao.getUpdatedBaseman())
        .isNotNull()
        .isInstanceOf(UpdatedBasemanDto.class);
  }

  @DisplayName("Score의 어웨이 팀 점수, 홈 팀 점수, 1회 초 관련 필드가 정상적으로 리턴되는지 확인한다.")
  @ParameterizedTest
  @ValueSource(longs = {1L})
  void UPDATED_SCORE가_리턴된다(Long game_id) throws Exception {
    assertThat(statusDao.getScores(game_id).getAwayScore()).isEqualTo(2);
    assertThat(statusDao.getScores(game_id).getHomeScore()).isEqualTo(3);
    assertThat(statusDao.getScores(game_id).getInningIndex()).isEqualTo(1);
    assertThat(statusDao.getScores(game_id).getInningType()).isEqualTo(InningType.LATE);
  }

  @DisplayName("Player가 정상적으로 ArrayList에 담겨 리턴되는 지 확인한다.")
  @Test
  void UPDATED_PLAYER가_리턴된다() {
    assertThat(statusDao.getUpdatedPlayers(1L))
        .isNotNull();
    assertThat(statusDao.getUpdatedPlayers(1L)
        .stream().allMatch(Objects::nonNull)).isTrue();
  }
}

package com.codesquad.baseball06.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.codesquad.baseball06.model.dao.PlateAppearanceDao;
import com.codesquad.baseball06.model.dao.StatusDao;
import com.codesquad.baseball06.model.entity.Batter;
import com.codesquad.baseball06.model.entity.Game;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.entity.InningStatus;
import com.codesquad.baseball06.model.entity.Pitcher;
import com.codesquad.baseball06.model.type.BattingResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlateAppearanceServiceTest {

  private static final Logger log = LoggerFactory.getLogger(PlateAppearanceServiceTest.class);
  private PlateAppearanceService plateAppearanceService;
  private Pitcher pitcher;
  private Batter batter;
  private HalfInning sampleHalfInning;

  @Autowired
  private DevService devService;

  @Autowired
  private PlateAppearanceService paService;

  @Autowired
  private GameService gameService;

  @Autowired
  private PlateAppearanceDao appearanceDao;

  @Autowired
  private StatusDao statusDao;

//  @BeforeEach
//  void setUp() {
//    this.plateAppearanceService = new PlateAppearanceService();
//
//    pitcher = devService.createPitchers("HOME").get(0);
//    batter = devService.createBatters("AWAY").get(0);
//  }

  @DisplayName("데이터베이스에 battingResult가 최종적으로 업데이트되는 지 판단하는 테스트이다.")
  @Test
  void DB에_BATTING_RESULT가_UPDATE된다() {

    //given 1
    Game game = gameService.getGame(1L);
    HalfInning halfInning = gameService.start(game);
    assertThat(halfInning).isNotNull();
    InningStatus beforeInningStatus = statusDao.getInningStatus();

    //when
    BattingResult battingResultAfterPA = gameService.proceed(game);
    assertThat(battingResultAfterPA).isNotNull();

    //then
    InningStatus afterInningStatus = statusDao.getInningStatus();
    assertThat(!beforeInningStatus.getStatus().equals(afterInningStatus.getStatus()))
        .isTrue();

  }

//  @TestQuery
//  void batting() {
//    sampleHalfInning = HalfInning.create(3L, 1, 1, InningType.EARLY, 0, 1, 1);
//
//    assertThat(plateAppearanceService.batting(sampleHalfInning, pitcher, batter))
//        .isInstanceOf(BattingResult.class);
//  }
//
//  @TestQuery
//  void batting_0S_3B_1O() {
//    sampleHalfInning = HalfInning.create(3L, 1, 1, InningType.EARLY, 0, 3, 1);
//
//    assertThat(plateAppearanceService.batting(sampleHalfInning, pitcher, batter))
//        .isInstanceOf(BattingResult.class);
//  }
//
//  @TestQuery
//  void batting_2S_1B_1O() {
//    sampleHalfInning = HalfInning.create(3L, 1, 1, InningType.EARLY, 2, 1, 1);
//
//    assertThat(plateAppearanceService.batting(sampleHalfInning, pitcher, batter))
//        .isInstanceOf(BattingResult.class);
//  }
//
//  @TestQuery
//  void batting_2S_1B_2O() {
//    sampleHalfInning = HalfInning.create(3L, 1, 1, InningType.EARLY, 2, 1, 2);
//
//    assertThat(plateAppearanceService.batting(sampleHalfInning, pitcher, batter))
//        .isInstanceOf(BattingResult.class);
//  }
}

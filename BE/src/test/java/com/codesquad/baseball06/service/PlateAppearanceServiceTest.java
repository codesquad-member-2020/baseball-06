package com.codesquad.baseball06.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.codesquad.baseball06.model.entity.Batter;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.entity.Pitcher;
import com.codesquad.baseball06.model.type.BattingResult;
import com.codesquad.baseball06.model.type.InningType;
import org.junit.jupiter.api.BeforeEach;
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

  @BeforeEach
  void setUp() {
    this.plateAppearanceService = new PlateAppearanceService();

    pitcher = devService.createPitchers("HOME").get(0);
    batter = devService.createBatters("AWAY").get(0);
  }

  @Test
  void batting() {
    sampleHalfInning = HalfInning.create(3L, 1, 1, InningType.EARLY, 0, 1, 1);

    assertThat(plateAppearanceService.batting(sampleHalfInning, pitcher, batter))
        .isInstanceOf(BattingResult.class);
  }

  @Test
  void batting_0S_3B_1O() {
    sampleHalfInning = HalfInning.create(3L, 1, 1, InningType.EARLY, 0, 3, 1);

    assertThat(plateAppearanceService.batting(sampleHalfInning, pitcher, batter))
        .isInstanceOf(BattingResult.class);
  }

  @Test
  void batting_2S_1B_1O() {
    sampleHalfInning = HalfInning.create(3L, 1, 1, InningType.EARLY, 2, 1, 1);

    assertThat(plateAppearanceService.batting(sampleHalfInning, pitcher, batter))
        .isInstanceOf(BattingResult.class);
  }

  @Test
  void batting_2S_1B_2O() {
    sampleHalfInning = HalfInning.create(3L, 1, 1, InningType.EARLY, 2, 1, 2);

    assertThat(plateAppearanceService.batting(sampleHalfInning, pitcher, batter))
        .isInstanceOf(BattingResult.class);
  }
}

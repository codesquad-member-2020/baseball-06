package com.codesquad.baseball06.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.codesquad.baseball06.model.Batter;
import com.codesquad.baseball06.model.Inning;
import com.codesquad.baseball06.model.Pitcher;
import com.codesquad.baseball06.model.type.InningType;
import com.codesquad.baseball06.model.type.BattingResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlateAppearanceServiceTest {

  private static final Logger log = LoggerFactory.getLogger(PlateAppearanceServiceTest.class);
  private PlateAppearanceService plateAppearanceService;
  private Pitcher pitcher;
  private Batter batter;
  private Inning sampleInning;

  @BeforeEach
  void setUp() {
    this.plateAppearanceService = new PlateAppearanceService();

    pitcher = Pitcher.create("김투수");
    batter = Batter.create("홍타자", 0.200);
  }

  @Test
  void batting() {
    sampleInning = Inning.create(3, 1, InningType.EARLY, 0, 1, 1);

    assertThat(plateAppearanceService.batting(sampleInning, pitcher, batter))
        .isInstanceOf(BattingResult.class);
  }

  @Test
  void batting_0S_3B_1O() {
    sampleInning = Inning.create(3, 1, InningType.EARLY, 0, 3, 1);

    assertThat(plateAppearanceService.batting(sampleInning, pitcher, batter))
        .isInstanceOf(BattingResult.class);
  }

  @Test
  void batting_2S_1B_1O() {
    sampleInning = Inning.create(3, 1, InningType.EARLY, 2, 1, 1);

    assertThat(plateAppearanceService.batting(sampleInning, pitcher, batter))
        .isInstanceOf(BattingResult.class);
  }

  @Test
  void batting_2S_1B_2O() {
    sampleInning = Inning.create(3, 1, InningType.EARLY, 2, 1, 2);

    assertThat(plateAppearanceService.batting(sampleInning, pitcher, batter))
        .isInstanceOf(BattingResult.class);
  }
}

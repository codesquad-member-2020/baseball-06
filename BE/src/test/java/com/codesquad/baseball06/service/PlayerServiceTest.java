package com.codesquad.baseball06.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.codesquad.baseball06.model.Inning;
import com.codesquad.baseball06.model.Player;
import com.codesquad.baseball06.model.type.InningType;
import com.codesquad.baseball06.model.type.PitchingResult;
import com.codesquad.baseball06.model.type.PlayerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlayerServiceTest {

  private static final Logger log = LoggerFactory.getLogger(PlayerServiceTest.class);
  private PlayerService playerService;
  private Player pitcher;
  private Player batter;
  private Inning sampleInning;

  @BeforeEach
  void setUp() {
    this.playerService = new PlayerService();
    pitcher = Player.create("김투수", PlayerType.PITCHER, 0.200);
    batter = Player.create("홍타자", PlayerType.BATTER, 0.200);
  }

  @Test
  void batting() {
    sampleInning = Inning.create(3, 1, InningType.EARLY, 0, 1, 1);

    assertThat(playerService.batting(sampleInning, pitcher, batter))
        .isInstanceOf(PitchingResult.class);
  }

  @Test
  void batting_3B() {
    sampleInning = Inning.create(3, 1, InningType.EARLY, 0, 3, 1);

    assertThat(playerService.batting(sampleInning, pitcher, batter))
        .isInstanceOf(PitchingResult.class);
  }

  @Test
  void batting_2S_1O() {
    sampleInning = Inning.create(3, 1, InningType.EARLY, 2, 1, 1);

    assertThat(playerService.batting(sampleInning, pitcher, batter))
        .isInstanceOf(PitchingResult.class);
  }

  @Test
  void batting_2S_2O() {
    sampleInning = Inning.create(3, 1, InningType.EARLY, 2, 1, 2);

    assertThat(playerService.batting(sampleInning, pitcher, batter))
        .isInstanceOf(PitchingResult.class);
  }
}

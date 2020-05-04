package com.codesquad.baseball06.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.codesquad.baseball06.model.Player;
import com.codesquad.baseball06.model.type.PitchingResult;
import com.codesquad.baseball06.model.type.PlayerType;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlayerServiceTest {

  private static final Logger log = LoggerFactory.getLogger(PlayerServiceTest.class);
  private PlayerService playerService;
  private List<Player> samplePlayer;

  @BeforeEach
  void setUp() {
    this.playerService = new PlayerService();
    this.samplePlayer = new ArrayList<>();
    this.samplePlayer.add(Player.create("김투수", PlayerType.PITCHER, 0.200));
    this.samplePlayer.add(Player.create("홍타자", PlayerType.BATTER, 0.200));
  }

  @Test
  void betting() {
    log.debug("### {}, {} : ", samplePlayer.get(0), samplePlayer.get(1));
    assertThat(playerService.betting(samplePlayer.get(0), samplePlayer.get(1)))
        .isInstanceOf(PitchingResult.class);
  }
}

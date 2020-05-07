package com.codesquad.baseball06.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlayerTest {

  @Test
  void pitcher_create() {
    Player player = Pitcher.create(1L, 2L, "Dan");
    assertThat(player.getId()).isEqualTo(1L);
  }

  @Test
  void batter_create() {
    Player player = Batter.create(1L, 1L, "Sigrid", 0.333);
    assertThat(player.getId()).isEqualTo(1L);
  }
}

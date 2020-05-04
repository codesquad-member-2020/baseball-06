package com.codesquad.baseball06.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.codesquad.baseball06.model.type.PlayerType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlayerTest {

  @Test
  void create() {
    Player player = Player.create(1L, "Dan", PlayerType.BATTER, 0.333);
    assertThat(player.getId()).isEqualTo(1L);
  }
}
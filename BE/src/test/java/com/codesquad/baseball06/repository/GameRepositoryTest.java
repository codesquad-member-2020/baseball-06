package com.codesquad.baseball06.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.codesquad.baseball06.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GameRepositoryTest {

  private final Logger logger = LoggerFactory.getLogger(GameRepositoryTest.class);

  @Autowired
  private GameRepository gameRepository;

  @BeforeEach
  void setUp() {
  }

  @Test
  void findGameById() {
    assertThat(gameRepository.findGameById(1L).getClass())
        .isNotNull()
        .isEqualTo(Game.class);
  }
}

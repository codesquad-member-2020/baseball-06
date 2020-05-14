package com.codesquad.baseball06.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.codesquad.baseball06.model.entity.Game;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.entity.Team;
import com.codesquad.baseball06.model.type.BattingResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HalfInningServiceTest {

  private static final Logger log = LoggerFactory.getLogger(InningService.class);

  @Autowired
  private InningService inningService;

  @Autowired
  private GameService gameService;

  private Team home;
  private Team away;
  private HalfInning halfInning;

//  @DisplayName("가상의 HalfInning을 만듭니다.")
//  @BeforeEach
//  void setUp() {
//    Game testGame = gameService.getGame(1L);
//    gameService.start(testGame);
//  }


  @DisplayName("scoring 테스트를 하기 위해 HIT의 상황을 가정합니다.")
  @Test
  void SCORE가_추가된다() {

    //given
    Game testGame = gameService.getGame(1L);
    gameService.start(testGame);
    Game testGame2 = gameService.getGame(1L);
    int beforeScore = inningService.getHalfInning(1L).getScore();

    int hitCount = 0;

    //when
    do {
      if (gameService.proceed(testGame2).equals(BattingResult.HIT)) {
        hitCount++;
      }
    } while (hitCount < 4);

    //then
    int afterScore = inningService.getHalfInning(1L).getScore();
    assertThat(beforeScore).isNotEqualTo(afterScore);

    }
}

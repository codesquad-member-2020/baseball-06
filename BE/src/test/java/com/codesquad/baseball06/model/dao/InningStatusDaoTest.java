package com.codesquad.baseball06.model.dao;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InningStatusDaoTest {

//  @Autowired
//  GameService gameService;
//
//  @Autowired
//  InningStatusDtoReturnDao inningStatusDtoReturnDao;
//
//  @Autowired
//  InningStatusDao inningStatusDao;
//
//  @DisplayName("BASEMAN이 HIT이거나 BASE ON BALL일 때 업데이트된다. 단, 항시 결과가 나오는 것은 아니기에 test가 fail할 수도 있다.")
//  @Test
//  void BASEMAN이_UPDATE된다() {
//    //given
//    Game game = gameService.getGame(1L);
//    HalfInning halfInning = gameService.start(game);
//    assertThat(halfInning).isNotNull();
//    gameService.proceed(game);
//
//    //proceed
//    UpdatedBasemanDto previousBaseman = inningStatusDtoReturnDao.getUpdatedBaseman();
//    UpdatedBasemanDto afterBaseman;
//
//    //when
//    do {
//      afterBaseman = inningStatusDtoReturnDao.getUpdatedBaseman();
//    } while (gameService.proceed(game) == BattingResult.HIT
//        || gameService.proceed(game) == BattingResult.BASE_ON_BALL);
//
//    //then
//    assertThat(previousBaseman).isNotEqualTo(afterBaseman);
//  }
}

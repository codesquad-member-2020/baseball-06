package com.codesquad.baseball06.model.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.codesquad.baseball06.dto.RawPlateAppearanceDto;
import com.codesquad.baseball06.dto.UpdatedBasemanDto;
import com.codesquad.baseball06.model.entity.Game;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.type.BattingResult;
import com.codesquad.baseball06.service.GameService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InningStatusAndPlateAppearanceUpdateDaoTest {

  @Autowired
  GameService gameService;

  @Autowired
  InningStatusAndPlateAppearanceDtoReturnDao inningStatusAndPlateAppearanceDtoReturnDao;

  @Autowired
  InningStatusAndPlateAppearanceUpdateDao inningStatusAndPlateAppearanceUpdateDao;

  @DisplayName("BASEMAN이 HIT이거나 BASE ON BALL일 때 업데이트된다. 단, 항시 결과가 나오는 것은 아니기에 test가 fail할 수도 있다.")
  @Test
  void BASEMAN이_UPDATE된다() {
    //given
    Game game = gameService.getGame(1L);
    HalfInning halfInning = gameService.start(game);
    assertThat(halfInning).isNotNull();
    gameService.proceed(game);

    //proceed
    UpdatedBasemanDto previousBaseman = inningStatusAndPlateAppearanceDtoReturnDao
        .getUpdatedBaseman();
    UpdatedBasemanDto afterBaseman;

    //when
    do {
      afterBaseman = inningStatusAndPlateAppearanceDtoReturnDao.getUpdatedBaseman();
    } while (gameService.proceed(game) == BattingResult.HIT
        || gameService.proceed(game) == BattingResult.BASE_ON_BALL);

    //then
    assertThat(previousBaseman).isNotEqualTo(afterBaseman);
  }

  @Test
  void INNING이_END로_바뀐다() {
    //given
    Game game = gameService.getGame(1L);
    HalfInning halfInning = gameService.start(game);
    assertThat(halfInning).isNotNull();
    Boolean beforeBoolean = inningStatusAndPlateAppearanceDtoReturnDao
        .getLastInningEndsForTest(halfInning.getId());

    //when
    gameService.proceed(game);
    BattingResult battingResult;
    while (gameService.proceed(game) != BattingResult.END) {
      battingResult = gameService.proceed(game);
    }
    Boolean afterBoolean = inningStatusAndPlateAppearanceDtoReturnDao
        .getLastInningEndsForTest(halfInning.getId());

    //then
    assertThat(beforeBoolean).isNotEqualTo(afterBoolean);
  }

  @DisplayName("addHalfInning을 했을 때, 아웃/안타가 되었을 때 plate_appearance가 새로 추가되는 지 확인한다.")
  @Test
  void PLATE_APPEARANCE가_새로운_하프이닝에_추가된다() {

    //given
    Game game = gameService.getGame(1L);
    RawPlateAppearanceDto beforeStartPaDto = inningStatusAndPlateAppearanceDtoReturnDao
        .getLastPlateAppearance(1L);

    HalfInning halfInning = gameService.start(game);
    assertThat(halfInning).isNotNull();
    RawPlateAppearanceDto afterStartPaDto = inningStatusAndPlateAppearanceDtoReturnDao
        .getLastPlateAppearance(halfInning.getId());

    //when
    gameService.proceed(game);
    BattingResult battingResult;


    while (gameService.proceed(game) != BattingResult.HIT
        || gameService.proceed(game) != BattingResult.BASE_ON_BALL
        || gameService.proceed(game) != BattingResult.OUT
        || gameService.proceed(game) != BattingResult.END) {

      battingResult = gameService.proceed(game);
    }

    RawPlateAppearanceDto afterProceedPaDto = inningStatusAndPlateAppearanceDtoReturnDao
        .getLastPlateAppearance(halfInning.getId());

    //then
    assertThat(beforeStartPaDto).isNotEqualTo(afterProceedPaDto);
    assertThat(beforeStartPaDto).isNotEqualTo(afterStartPaDto);
    assertThat(afterStartPaDto).isNotEqualTo(afterProceedPaDto);
  }

  @DisplayName("스트라이크, 볼이라는 타구 마다 새로운 DETAIL")
  @Test
  void DETAIL_PLATE_APPEARANCE가_추가된다() {
    //
  }
}

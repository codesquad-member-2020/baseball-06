package com.codesquad.baseball06.controller;

import com.codesquad.baseball06.dto.ApiResponse;
import com.codesquad.baseball06.dto.BattingResultReturnDto;
import com.codesquad.baseball06.dto.InningInfoReturnDto;
import com.codesquad.baseball06.message.AuthMessages;
import com.codesquad.baseball06.model.entity.Game;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.entity.InningStatus;
import com.codesquad.baseball06.model.type.BattingResult;
import com.codesquad.baseball06.model.type.TeamType;
import com.codesquad.baseball06.service.GameService;
import com.codesquad.baseball06.service.InningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "prod")
@RequestMapping("/api")
public class GameController {

  private static final Logger log = LoggerFactory.getLogger(GameController.class);
  private final GameService gameService;
  private final InningService inningService;

  public GameController(GameService gameService, InningService inningService) {
    this.gameService = gameService;
    this.inningService = inningService;
  }

  @GetMapping("/game/start/{gameId}")
  public ApiResponse startGame(@PathVariable Long gameId) {
    Game game = gameService.getGame(gameId);
    gameService.start(game);

    return ApiResponse.ok(null);
  }

  @GetMapping("/game/proceed/{gameId}")
  public ApiResponse proceedGame(@PathVariable Long gameId) {
    Game game = gameService.getGame(gameId);
    BattingResult battingResult = gameService.proceed(game);
    BattingResultReturnDto battingResultReturnDto = BattingResultReturnDto.create(battingResult);

    return ApiResponse.ok(battingResultReturnDto);
  }

  @GetMapping("/game/info/{gameId}")
  public ApiResponse inningInfo(@PathVariable Long gameId) {
    Game game = gameService.getGame(gameId);
    List<HalfInning> earlyInningList = game.getEarlyInningList();
    List<HalfInning> lateInningList = game.getLateInningList();

    InningStatus inningStatus = inningService.getInningStatus(gameId);
    // BaseStatus 를 만들고 그것을 return 에 넣어야함
    InningInfoReturnDto inningInfoReturnDto = InningInfoReturnDto
        .create(earlyInningList, lateInningList, inningStatus);

    return ApiResponse.ok(inningInfoReturnDto);
  }

  @ApiOperation(value = "", notes = AuthMessages.JOIN)
  @GetMapping("/game/join/{gameId}")
  public ApiResponse joinUser(@PathVariable Long gameId, @RequestParam String teamType,
      HttpServletRequest httpServletRequest) {
    Game game = gameService.getGame(gameId);
    String[] parsedJwt = httpServletRequest.getHeader("Authorization").split(" ");

    game = gameService.joinUser(game, TeamType.valueOf(teamType), parsedJwt[1]);
    return ApiResponse.ok(game.getUsers());
  }
}

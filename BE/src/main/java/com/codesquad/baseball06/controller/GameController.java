package com.codesquad.baseball06.controller;

import com.codesquad.baseball06.dto.ApiResponse;
import com.codesquad.baseball06.model.entity.Game;
import com.codesquad.baseball06.model.entity.User;
import com.codesquad.baseball06.model.type.TeamType;
import com.codesquad.baseball06.service.GameService;
import io.swagger.annotations.Api;
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

  public GameController(GameService gameService) {
    this.gameService = gameService;
  }

  @GetMapping("/game/start/{gameId}")
  public ApiResponse startGame(@PathVariable Long gameId) {
    Game game = gameService.getGame(gameId);
    return ApiResponse.ok(gameService.start(game));
  }

  @GetMapping("/game/join/{gameId}")
  public ApiResponse joinUser(@PathVariable Long gameId, @RequestParam String teamType,
      @RequestParam String userEmail) {
    Game game = gameService.getGame(gameId);

    return ApiResponse
        .ok(gameService.joinUser(game, TeamType.valueOf(teamType), User.create(userEmail)));
  }
}

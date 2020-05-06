package com.codesquad.baseball06.controller;

import com.codesquad.baseball06.message.DevMessage;
import com.codesquad.baseball06.model.ApiResponse;
import com.codesquad.baseball06.model.Batter;
import com.codesquad.baseball06.model.Inning;
import com.codesquad.baseball06.model.Pitcher;
import com.codesquad.baseball06.model.Team;
import com.codesquad.baseball06.model.type.BattingResult;
import com.codesquad.baseball06.model.type.InningType;
import com.codesquad.baseball06.service.DevService;
import com.codesquad.baseball06.service.InningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "dev")
@RequestMapping("/dev")
public class DevController {

  private static final Logger log = LoggerFactory.getLogger(DevController.class);

  private final InningService inningService;
  private final DevService devService;
  private final Inning inning;
  private final Team home;
  private final Team away;

  public DevController(InningService inningService, DevService devService) {
    this.inningService = inningService;
    this.devService = devService;
    inning = Inning.create(1L, 0, 1, InningType.EARLY, 0, 0, 0);
    home = devService.teamInitHelper("home");
    away = devService.teamInitHelper("away");
  }

  @ApiOperation(value = "", notes = DevMessage.INIT)
  @GetMapping("/init")
  public ApiResponse init() {
    inning.newInning();
    return ApiResponse.ok(inning.getStatus());
  }

  @ApiOperation(value = "", notes = DevMessage.PITCHING)
  @GetMapping("/pitching")
  public ApiResponse pitching() {
    Pitcher pitcher = home.getPitcherList().get(0);
    Batter batter = away.getBatterList().get(0);
    BattingResult battingResult = inningService.doWork(inning, pitcher, batter);

    if (battingResult.equals(BattingResult.HIT)) {
      inning.newPlateAppearance();
    }

    Map<String, Object> resultMap = new HashMap<>();
    resultMap.put("battingResult", battingResult);
    resultMap.put("inningStatus", inning.getStatus());

    ApiResponse apiResponse = ApiResponse.ok(resultMap);

    if (inning.getOut().equals(3)) {
      init();
    }

    return apiResponse;
  }

  @ApiOperation(value = "", notes = DevMessage.TEAM_AND_PLAYER_INFO)
  @GetMapping("/team")
  public ApiResponse teamInfo() {
    return ApiResponse.ok(getTeamInfo());
  }

  private Map<String, Team> getTeamInfo() {
    Map<String, Team> resultMap = new HashMap<>();

    resultMap.put("home", home);
    resultMap.put("away", away);

    return resultMap;
  }
}

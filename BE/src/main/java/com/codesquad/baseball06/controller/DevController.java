package com.codesquad.baseball06.controller;

import com.codesquad.baseball06.dto.BattingResultDto;
import com.codesquad.baseball06.message.DevMessage;
import com.codesquad.baseball06.dto.ApiResponse;
import com.codesquad.baseball06.model.entity.Batter;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.entity.Pitcher;
import com.codesquad.baseball06.model.entity.Team;
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
  private final HalfInning halfInning;
  private final Team home;
  private final Team away;

  public DevController(InningService inningService, DevService devService) {
    this.inningService = inningService;
    this.devService = devService;
    halfInning = HalfInning.create(1L, 0, 1, InningType.EARLY, 0, 0, 0);
    home = devService.teamInitHelper("home");
    away = devService.teamInitHelper("away");
  }

  @ApiOperation(value = "", notes = DevMessage.INIT)
  @GetMapping("/init")
  public ApiResponse init() {
    halfInning.newInning();
    return ApiResponse.ok(halfInning.getStatus());
  }

  @ApiOperation(value = "", notes = DevMessage.PITCHING)
  @GetMapping("/pitching")
  public ApiResponse pitching() {
    Pitcher pitcher = home.getPitcherList().get(0);
    Batter batter = away.getBatterList().get(0);
    BattingResult battingResult = inningService.doWork(halfInning, pitcher, batter);

    BattingResultDto battingResultDto = BattingResultDto.create(battingResult);
    ApiResponse apiResponse = ApiResponse.ok(battingResultDto);

    if (halfInning.getOut().equals(3)) {
      //TODO GameService로 해당 로직을 이동한다.
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

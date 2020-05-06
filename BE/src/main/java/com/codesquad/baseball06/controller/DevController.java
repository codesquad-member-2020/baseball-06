package com.codesquad.baseball06.controller;

import com.codesquad.baseball06.model.ApiResponse;
import com.codesquad.baseball06.model.Batter;
import com.codesquad.baseball06.model.Inning;
import com.codesquad.baseball06.model.Pitcher;
import com.codesquad.baseball06.model.Team;
import com.codesquad.baseball06.model.type.BattingResult;
import com.codesquad.baseball06.model.type.InningType;
import com.codesquad.baseball06.service.InningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
  private Inning inning;
  private Team home;
  private Team away;

  public DevController(InningService inningService) {
    this.inningService = inningService;
  }

  @GetMapping("/test")
  public String returnTestString() {
    log.debug("### test working");
    return "test";
  }

  @ApiOperation(value = "", notes = "게임 초기화")
  @GetMapping("/init")
  public ApiResponse init() {
    inning = Inning.create(0, 1, InningType.EARLY, 0, 0, 0);
    home = teamInitHelper("home");
    away = teamInitHelper("away");

    return ApiResponse.ok(inning.getStatus());
  }

  private Team teamInitHelper(String teamName) {
    List<Pitcher> pitcherList = new ArrayList<>();
    List<Batter> batterList = new ArrayList<>();

    pitcherList.add(Pitcher.create(teamName + "투수 "));

    for (int i = 0; i < 3; i++) {
      Batter batter = Batter.create(teamName + "타자" + i, 0.122);
      batterList.add(batter);
    }

    return Team.create(teamName, pitcherList, batterList);
  }

  @ApiOperation(value = "", notes = "테스트 투구")
  @GetMapping("/dotest")
  public ApiResponse dotest() {
    BattingResult battingResult = inningService
        .doWork(inning, home.getPitcherList().get(0), away.getBatterList().get(0));

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

  @ApiOperation(value = "", notes = "팀 정보 및 선수정보 가져오기")
  @GetMapping("/team")
  public ApiResponse team() {
    Map<String, Object> resultMap = new HashMap<>();

    resultMap.put("home", home);
    resultMap.put("away", away);

    return ApiResponse.ok(resultMap);
  }
}

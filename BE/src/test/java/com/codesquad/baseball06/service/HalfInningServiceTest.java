package com.codesquad.baseball06.service;

import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.entity.Team;
import com.codesquad.baseball06.model.type.BattingResult;
import com.codesquad.baseball06.model.type.InningType;
import org.junit.jupiter.api.BeforeEach;
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
  private DevService devService;

  private Team home;
  private Team away;
  private HalfInning halfInning;

  @BeforeEach
  void setUp() {
    this.inningService = new InningService(new PlateAppearanceService());

    halfInning = HalfInning.create(1L, 1, 1, InningType.EARLY, 2, 0, 2);
    home = devService.teamInitHelper("home");
    away = devService.teamInitHelper("away");
  }

  @Test
  void doWork() {
    for (int i = 0; i < 9; i++) {
      BattingResult battingResult = inningService
          .doWork(halfInning, home.getPitcherList().get(0), away.getBatterList().get(0));
      log.debug("### dowork : {}", battingResult);
      log.debug("### inning : {}", halfInning.getStatus());
    }
  }
}

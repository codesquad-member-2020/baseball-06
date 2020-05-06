package com.codesquad.baseball06.controller;

import com.codesquad.baseball06.model.Batter;
import com.codesquad.baseball06.model.Inning;
import com.codesquad.baseball06.model.Pitcher;
import com.codesquad.baseball06.model.type.BattingResult;
import com.codesquad.baseball06.model.type.InningType;
import com.codesquad.baseball06.service.InningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InningController {

  private static final Logger log = LoggerFactory.getLogger(InningController.class);
  private final InningService inningService;

  public InningController(InningService inningService) {
    this.inningService = inningService;
  }

  @GetMapping("/dowork")
  public BattingResult doWork() {
    Inning inning = Inning.create(5, 1, InningType.EARLY, 2, 1, 1);
    Pitcher pitcher = Pitcher.create("김투수");
    Batter batter = Batter.create("홍타자", 0.222);

    return inningService.doWork(inning, pitcher, batter);
  }
}

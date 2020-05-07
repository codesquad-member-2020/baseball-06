package com.codesquad.baseball06.controller;

import com.codesquad.baseball06.model.ApiResponse;
import com.codesquad.baseball06.model.Batter;
import com.codesquad.baseball06.model.Inning;
import com.codesquad.baseball06.model.Pitcher;
import com.codesquad.baseball06.model.type.InningType;
import com.codesquad.baseball06.service.InningService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "prod")
@RequestMapping("/api")
public class InningController {

  private static final Logger log = LoggerFactory.getLogger(InningController.class);
  private final InningService inningService;

  public InningController(InningService inningService) {
    this.inningService = inningService;
  }

  @GetMapping("/dowork")
  public ApiResponse doWork() {
    return null;
  }
}

package com.codesquad.baseball06.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev")
public class DevController {

  private static final Logger log = LoggerFactory.getLogger(DevController.class);

  @GetMapping("/test")
  public String returnTestString() {
    log.debug("### test working");
    return "test";
  }
}

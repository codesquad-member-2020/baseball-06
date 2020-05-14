package com.codesquad.baseball06.controller;


import com.codesquad.baseball06.message.AuthMessages;
import com.codesquad.baseball06.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.websocket.server.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "prod")
@RequestMapping("/api/oauth")
public class AuthController {

  private static final Logger log = LoggerFactory.getLogger(AuthController.class);
  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @ApiOperation(value = "", notes = AuthMessages.GET_TOKEN)
  @ResponseStatus(HttpStatus.SEE_OTHER)
  @GetMapping("/token")
  public ResponseEntity<String> token() {
    return new ResponseEntity<>(authService.login(), HttpStatus.SEE_OTHER);
  }

  @ApiOperation(value = "", notes = AuthMessages.CALLBACK)
  @GetMapping("/callback")
  public ResponseEntity<String> callback(@PathParam("code") String code) {
    log.debug("### callback");
    return new ResponseEntity<>(authService.callback(code), HttpStatus.SEE_OTHER);
  }
}

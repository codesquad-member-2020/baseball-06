package com.codesquad.baseball06.controller;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class GameControllerTest {

  private static final Logger log = LoggerFactory.getLogger(GameControllerTest.class);

  @LocalServerPort
  private int port;

  @Test
  void startGame() {
    HttpHeaders headers = new HttpHeaders();

    String baseUrl = "http://localhost:" + port + "/api/";
    UriComponents builder = UriComponentsBuilder
        .fromHttpUrl(baseUrl)
        .path("/game/join")
        .path("/2")
        .queryParam("teamType", "AWAY")
        .queryParam("userEmail", "dan@gmail.com")
        .build(false);

    ResponseEntity<String> response = new TestRestTemplate().exchange(
        builder.toUri(), HttpMethod.GET, new HttpEntity<String>(headers), String.class);

    log.debug("### getBody : {} ", response.getBody());
  }

  @Test
  void joinUser() {
  }
}

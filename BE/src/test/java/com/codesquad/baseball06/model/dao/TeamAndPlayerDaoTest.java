package com.codesquad.baseball06.model.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.codesquad.baseball06.model.entity.Batter;
import com.codesquad.baseball06.model.entity.Pitcher;
import com.codesquad.baseball06.model.entity.Team;
import com.codesquad.baseball06.service.DevService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeamAndPlayerDaoTest {

  private static final Logger log = LoggerFactory.getLogger(TeamAndPlayerDaoTest.class);

  @Autowired
  private TeamDao teamDao;

  @Autowired
  private PlayerDao playerDao;

  @Autowired
  private DevService devService;

  @BeforeEach
  void setUp() {
    String teamName = "away team sk";
    List<Pitcher> pitcherList = devService.createPitchers(teamName);
    List<Batter> batterList = devService.createBatters(teamName);
    Team team = devService.teamInitHelper(teamName);

    teamDao.insertTeam(team);
    team.getPitcherList().forEach(pitcher -> playerDao.insertPitcher(1, 0, pitcher.getName()));
    team.getBatterList().forEach(
        batter -> playerDao.insertBatter(1, 0, batter.getName(), batter.getBattingAverage()));
  }

  @Test
  void validateDaoMethods() {
    log.debug("### lll");
    assertThat(playerDao.findPitcherById(1L))
        .isNotNull();
    assertThat(playerDao.findBatterById(2L))
        .isNotNull();
//    assertThat(playerDao.findBatterById(3L))
//        .isNotNull();
//    assertThat(teamDao.findTeamById(1L))
//        .isNotNull();
  }
}

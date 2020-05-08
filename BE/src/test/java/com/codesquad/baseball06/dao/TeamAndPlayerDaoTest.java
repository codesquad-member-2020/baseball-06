package com.codesquad.baseball06.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.codesquad.baseball06.model.Batter;
import com.codesquad.baseball06.model.Pitcher;
import com.codesquad.baseball06.model.Team;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeamAndPlayerDaoTest {

  @Autowired
  private TeamDao teamDao;

  @Autowired
  private PlayerDao playerDao;

  @BeforeEach
  void setUp() {
    List<Pitcher> pitcherList = new ArrayList<>();
    pitcherList.add(Pitcher.create("Honux"));

    List<Batter> batterList = new ArrayList<>();
    batterList.add(Batter.create("Sigrid", 0.333));
    batterList.add(Batter.create("Dan", 0.222));

    Team team = Team.create("Backend", pitcherList, batterList);
    teamDao.insertTeam(team);
    team.getPitcherList().forEach(pitcher ->
        playerDao.insertPlayer(0, 0, pitcher.getName(), pitcher.getBattingAverage()));
    team.getBatterList().forEach(batter ->
        playerDao.insertPlayer(0, 1, batter.getName(), batter.getBattingAverage()));
  }

  @Test
  void validateDaoMethods() {
    assertThat(playerDao.findPitcherById(1L)).isNotNull();
    assertThat(playerDao.findBatterById(2L)).isNotNull();
    assertThat(playerDao.findBatterById(3L)).isNotNull();
    assertThat(teamDao.findTeamById(1L)).isNotNull();
  }
}
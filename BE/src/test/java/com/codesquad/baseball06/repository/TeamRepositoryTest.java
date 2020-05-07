package com.codesquad.baseball06.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.codesquad.baseball06.model.Team;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeamRepositoryTest {

  private final Logger logger = LoggerFactory.getLogger(GameRepositoryTest.class);

  @Autowired
  private TeamRepository teamRepository;

  @Test
  void findTeamById() {
    assertThat(teamRepository.findTeamById(1L).getClass())
        .isNotNull()
        .isEqualTo(Team.class);
  }
}

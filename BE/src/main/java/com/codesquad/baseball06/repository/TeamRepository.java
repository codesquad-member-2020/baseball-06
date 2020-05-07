package com.codesquad.baseball06.repository;

import com.codesquad.baseball06.model.Team;
import com.codesquad.baseball06.service.DevService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TeamRepository {

  private final Logger logger = LoggerFactory.getLogger(TeamRepository.class);
  private final JdbcTemplate jdbcTemplate;

  private final RowMapper<Team> teamMapper = ((rs, rowNum) ->
      Team.create(rs.getLong(1)
          , rs.getString(2)
          // player repository 완성 후 수정
          , new DevService().createPitchers(rs.getString(2))
          , new DevService().createBatters(rs.getString(2))
      ));

  public TeamRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public Team findTeamById(Long id) {
    String query = new StringBuilder()
        .append("SELECT t.id, t.name ")
        .append("FROM team t ")
        .append("WHERE t.id = ?").toString();
    return jdbcTemplate.query(query, new Object[]{id}, teamMapper).get(0);
  }
}

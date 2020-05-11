package com.codesquad.baseball06.model.dao;

import static com.codesquad.baseball06.model.query.TeamQuery.FIND_BY_ID;

import com.codesquad.baseball06.model.dao.mapper.TeamMapper;
import com.codesquad.baseball06.model.entity.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TeamDao {

  private static final Logger logger = LoggerFactory.getLogger(TeamDao.class);
  private final NamedParameterJdbcTemplate jdbcTemplate;
  private final TeamMapper teamMapper;

  public TeamDao(NamedParameterJdbcTemplate jdbcTemplate, TeamMapper teamMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.teamMapper = teamMapper;
  }

  public Team findTeamById(Long id) {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("id", id);

    return jdbcTemplate.queryForObject(FIND_BY_ID, namedParameters, teamMapper).get(0);
  }
}

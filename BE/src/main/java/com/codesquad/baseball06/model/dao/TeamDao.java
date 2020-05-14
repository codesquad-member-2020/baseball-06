package com.codesquad.baseball06.model.dao;

import static com.codesquad.baseball06.model.query.TeamQuery.FIND_BY_ID;

import com.codesquad.baseball06.model.dao.mapper.EachTeamMapper;
import com.codesquad.baseball06.model.dao.mapper.TeamMapper;
import com.codesquad.baseball06.model.entity.Team;
import com.codesquad.baseball06.model.query.TeamQuery;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TeamDao {

  private final NamedParameterJdbcTemplate jdbcTemplate;
  private final TeamMapper teamMapper;
  private final EachTeamMapper eachTeamMapper;

  public TeamDao(NamedParameterJdbcTemplate jdbcTemplate, TeamMapper teamMapper,
      EachTeamMapper eachTeamMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.teamMapper = teamMapper;
    this.eachTeamMapper = eachTeamMapper;
  }

  public Team findTeamById(Long id) {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("id", id);

    return jdbcTemplate.queryForObject(TeamQuery.FIND_BY_ID, namedParameters, eachTeamMapper);
  }

  public List<Team> getAllTeamInfoByGameId(Long game_id) {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("game_id", game_id);

    List<Team> returnTeams = new ArrayList<>();

    Team awayTeam = jdbcTemplate
        .queryForObject(TeamQuery.FIND_AWAY_TEAM_BY_GAME_ID, namedParameters, eachTeamMapper);

    Team homeTeam = jdbcTemplate
        .queryForObject(TeamQuery.FIND_HOME_TEAM_BY_GAME_ID, namedParameters, eachTeamMapper);

    returnTeams.add(awayTeam);
    returnTeams.add(homeTeam);

    return returnTeams;
  }
}

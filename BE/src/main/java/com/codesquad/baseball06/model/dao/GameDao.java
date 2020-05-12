package com.codesquad.baseball06.model.dao;

import static com.codesquad.baseball06.model.query.GameQuery.FIND_BY_ID;
import static com.codesquad.baseball06.model.query.GameQuery.INSERT;
import static com.codesquad.baseball06.model.query.GameQuery.UPDATE_AWAY_USER;
import static com.codesquad.baseball06.model.query.GameQuery.UPDATE_HOME_USER;

import com.codesquad.baseball06.model.dao.mapper.GameMapper;
import com.codesquad.baseball06.model.entity.Game;
import com.codesquad.baseball06.model.entity.Team;
import com.codesquad.baseball06.model.entity.User;
import com.codesquad.baseball06.model.type.TeamType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class GameDao {

  private static final Logger logger = LoggerFactory.getLogger(TeamDao.class);
  private final NamedParameterJdbcTemplate jdbcTemplate;
  private final GameMapper gameMapper;

  public GameDao(NamedParameterJdbcTemplate jdbcTemplate, GameMapper gameMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.gameMapper = gameMapper;
  }

  public Game findGameById(Long id) {
    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);

    return jdbcTemplate.queryForObject(FIND_BY_ID, namedParameters, gameMapper).get(0);
  }

  public int create(Team away, Team home) {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("away_id", away.getId())
        .addValue("home_id", home.getId());

    return jdbcTemplate.update(INSERT, namedParameters);
  }

  public int join(long id, User user, TeamType teamType) {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("id", id)
        .addValue(teamType.name(), user.getEmail());

    if (teamType.equals(TeamType.AWAY)) {
      return jdbcTemplate.update(UPDATE_AWAY_USER, namedParameters);
    }
    return jdbcTemplate.update(UPDATE_HOME_USER, namedParameters);
  }
}

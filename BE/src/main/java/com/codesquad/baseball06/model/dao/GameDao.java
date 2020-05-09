package com.codesquad.baseball06.model.dao;

import static com.codesquad.baseball06.model.query.Game.INSERT;
import static com.codesquad.baseball06.model.query.Team.FIND_BY_ID;

import com.codesquad.baseball06.model.dao.mapper.GameMapper;
import com.codesquad.baseball06.model.entity.Game;
import com.codesquad.baseball06.model.entity.Team;
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

  public int createGame(Team away, Team home) {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("away_id", away.getId())
        .addValue("home_id", home.getId());

    return jdbcTemplate.update(INSERT, namedParameters);
  }
}

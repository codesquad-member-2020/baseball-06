package com.codesquad.baseball06.model.dao;

import static com.codesquad.baseball06.model.query.PlayerQuery.FIND_BY_ID_AND_TYPE;
import static com.codesquad.baseball06.model.query.PlayerQuery.FIND_BY_TYPE_AND_TEAM_ID;

import com.codesquad.baseball06.model.dao.mapper.BatterMapper;
import com.codesquad.baseball06.model.dao.mapper.PitcherMapper;
import com.codesquad.baseball06.model.entity.Batter;
import com.codesquad.baseball06.model.entity.Pitcher;
import com.codesquad.baseball06.model.type.PlayerType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDao {

  private static final Logger log = LoggerFactory.getLogger(PlayerDao.class);
  private final NamedParameterJdbcTemplate jdbcTemplate;
  private final PitcherMapper pitcherMapper;
  private final BatterMapper batterMapper;

  public PlayerDao(NamedParameterJdbcTemplate jdbcTemplate, PitcherMapper pitcherMapper,
      BatterMapper batterMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.pitcherMapper = pitcherMapper;
    this.batterMapper = batterMapper;
  }

  public Pitcher findPitcherById(Long id) {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("id", id)
        .addValue("type", PlayerType.PITCHER.getCode());

    return jdbcTemplate.queryForObject(FIND_BY_ID_AND_TYPE, namedParameters, pitcherMapper).get(0);
  }

  public List<Pitcher> findPitcherAndTeamId(Long teamId) {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("type", PlayerType.PITCHER.getCode())
        .addValue("team_id", teamId);

    return jdbcTemplate.queryForObject(FIND_BY_TYPE_AND_TEAM_ID, namedParameters, pitcherMapper);
  }

  public Batter findBatterById(Long id) {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("id", id)
        .addValue("type", PlayerType.BATTER.getCode());

    return jdbcTemplate.queryForObject(FIND_BY_ID_AND_TYPE, namedParameters, batterMapper).get(0);
  }

  public List<Batter> findBatterByTeamId(Long teamId) {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("type", PlayerType.BATTER.getCode())
        .addValue("team_id", teamId);

    return jdbcTemplate.queryForObject(FIND_BY_TYPE_AND_TEAM_ID, namedParameters, batterMapper);
  }
}

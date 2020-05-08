package com.codesquad.baseball06.model.dao;

import com.codesquad.baseball06.model.dao.mapper.MultipleBatterMapper;
import com.codesquad.baseball06.model.dao.mapper.MultiplePitcherMapper;
import com.codesquad.baseball06.model.dao.mapper.SingleBatterMapper;
import com.codesquad.baseball06.model.dao.mapper.SinglePitcherMapper;
import com.codesquad.baseball06.model.entity.Batter;
import com.codesquad.baseball06.model.entity.Pitcher;
import com.codesquad.baseball06.model.type.PlayerType;
import java.util.List;
import java.util.Optional;
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
  private final String singlePlayerQuery = new StringBuilder()
      .append("SELECT p.id, p.team_id, p.type, p.name, p.batting_average ")
      .append("FROM player p ")
      .append("WHERE p.id = :id ")
      .append("  AND p.type = :type")
      .toString();
  private final String multiplePlayerQuery = new StringBuilder()
      .append("SELECT p.id, p.team_id, p.type, p.name, p.batting_average ")
      .append("FROM player p ")
      .append("WHERE p.type = :type")
      .toString();

  public PlayerDao(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public Optional<Pitcher> findPitcherById(Long id) {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("id", id)
        .addValue("type", PlayerType.PITCHER.getCode());

    return Optional.ofNullable(
        jdbcTemplate.queryForObject(singlePlayerQuery, namedParameters, new SinglePitcherMapper()));
  }

  public List<Pitcher> findPitchers() {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("type", PlayerType.PITCHER.getCode());

    return jdbcTemplate
        .queryForObject(multiplePlayerQuery, namedParameters, new MultiplePitcherMapper());
  }

  public Optional<Batter> findBatterById(Long id) {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("id", id)
        .addValue("type", PlayerType.BATTER.getCode());

    return Optional.ofNullable(
        jdbcTemplate.queryForObject(singlePlayerQuery, namedParameters, new SingleBatterMapper()));
  }

  public List<Batter> findBatters() {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("type", PlayerType.BATTER.getCode());

    return jdbcTemplate.queryForObject(
        multiplePlayerQuery, namedParameters, new MultipleBatterMapper());
  }
}

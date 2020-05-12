package com.codesquad.baseball06.model.dao;

import com.codesquad.baseball06.model.dao.mapper.HalfInningMapper;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.query.HalfInningQuery;
import com.codesquad.baseball06.model.type.InningType;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class HalfInningDao {

  private static final Logger logger = LoggerFactory.getLogger(TeamDao.class);
  private final NamedParameterJdbcTemplate jdbcTemplate;
  private final HalfInningMapper halfInningMapper;

  public HalfInningDao(NamedParameterJdbcTemplate jdbcTemplate, HalfInningMapper halfInningMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.halfInningMapper = halfInningMapper;
  }

  public HalfInning findHalfInningById(Long id) {
    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);

    return Optional.ofNullable(jdbcTemplate
        .queryForObject(HalfInningQuery.FIND_BY_ID, namedParameters, halfInningMapper)
        .get(0))
        .orElseThrow(NoSuchElementException::new);
  }

  public HalfInning findHalfInningByGameIdAndLast(Long gameId) {
    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("game_id", gameId);

    return Optional.ofNullable(
        jdbcTemplate.queryForObject(
            HalfInningQuery.FIND_BY_GAME_ID, namedParameters, halfInningMapper).get(0))
        .orElseThrow(NoSuchElementException::new);
  }

  public List<HalfInning> findHalfInningByGameId(Long gameId) {
    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("game_id", gameId);

    try {
      return jdbcTemplate.queryForObject(
          HalfInningQuery.FIND_BY_GAME_ID, namedParameters, halfInningMapper);
    } catch (EmptyResultDataAccessException e) {
      return new ArrayList<>();
    }
  }

  public int create(Long gameId, Integer index, InningType inningType) {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("game_id", gameId)
        .addValue("inning_index", index)
        .addValue("type", inningType.getCode());

    return jdbcTemplate.update(HalfInningQuery.INSERT, namedParameters);
  }
}

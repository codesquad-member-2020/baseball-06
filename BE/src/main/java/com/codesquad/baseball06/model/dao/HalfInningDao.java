package com.codesquad.baseball06.model.dao;

import static com.codesquad.baseball06.model.query.HalfInning.FIND_BY_ID;
import static com.codesquad.baseball06.model.query.HalfInning.INSERT;

import com.codesquad.baseball06.model.dao.mapper.HalfInningMapper;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.type.InningType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    return jdbcTemplate.queryForObject(FIND_BY_ID, namedParameters, halfInningMapper)
        .get(0);
  }

  public int create(Long gameId, Integer index, InningType inningType) {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("game_id", gameId)
        .addValue("inning_index", index)
        .addValue("type", inningType.getCode());

    return jdbcTemplate.update(INSERT, namedParameters);
  }
}

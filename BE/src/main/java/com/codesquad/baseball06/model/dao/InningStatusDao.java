package com.codesquad.baseball06.model.dao;

import com.codesquad.baseball06.model.dao.mapper.InningStatusMapper;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.entity.InningStatus;
import com.codesquad.baseball06.model.query.InningStatusQuery;
import com.codesquad.baseball06.model.query.UpdateInningStatusQuery;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class InningStatusDao {

  private final NamedParameterJdbcTemplate jdbcTemplate;
  private final InningStatusMapper inningStatusMapper;

  public InningStatusDao(NamedParameterJdbcTemplate jdbcTemplate,
      InningStatusMapper inningStatusMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.inningStatusMapper = inningStatusMapper;
  }

  public int createNewInningStatus(HalfInning halfInning) {
    SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("half_inning_id", halfInning.getId());
    return jdbcTemplate
        .update(UpdateInningStatusQuery.CREATE_NEW_INNING_STATUS, sqlParameterSource);
  }

  public int updateInningStatus(HalfInning halfInning, String query) {
    InningStatus inningStatus = halfInning.getInningStatus();
    SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("strike_count", inningStatus.getStrike())
        .addValue("ball_count", inningStatus.getBall())
        .addValue("out_count", inningStatus.getOut())
        .addValue("half_inning_id", halfInning.getId());
    try {
      return jdbcTemplate.update(query, sqlParameterSource);
    } catch (Exception e) {
      throw new RuntimeException("무엇인가가 잘못되었습니다.");
    }
  }

  public InningStatus findInningStatusByGameId(Long gameId) {
    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("game_id", gameId);

    try {
      return jdbcTemplate
          .queryForObject(InningStatusQuery.FIND_BY_GAME_ID, namedParameters, inningStatusMapper)
          .get(0);
    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }

  public InningStatus findInningStatusByInningId(Long inningId) {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("half_inning_id", inningId);

    try {
      return jdbcTemplate
          .queryForObject(InningStatusQuery.FIND_BY_INNING_ID, namedParameters, inningStatusMapper)
          .get(0);
    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }
}

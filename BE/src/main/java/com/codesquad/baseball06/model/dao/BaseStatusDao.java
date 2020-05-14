package com.codesquad.baseball06.model.dao;

import com.codesquad.baseball06.model.dao.mapper.BaseStatusMapper;
import com.codesquad.baseball06.model.entity.BaseStatus;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.query.BaseStatusQuery;
import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class BaseStatusDao {

  private final NamedParameterJdbcTemplate jdbcTemplate;
  private final BaseStatusMapper baseStatusMapper;

  public BaseStatusDao(
      NamedParameterJdbcTemplate jdbcTemplate,
      BaseStatusMapper baseStatusMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.baseStatusMapper = baseStatusMapper;
  }

  public BaseStatus getBaseStatus(Long halfInningId) {
    SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("half_inning_id", halfInningId);
    try {
      return jdbcTemplate
          .queryForObject(BaseStatusQuery.GET_BASE_STATUS, sqlParameterSource, baseStatusMapper);
    } catch (EmptyResultDataAccessException e) {
      return null;
    }
  }

  public int updateBaseStatus(Long halfInningId, BaseStatus baseStatus) {
    SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("half_inning_id", halfInningId)
        .addValue("first_base", baseStatus.getFirstBase())
        .addValue("second_base", baseStatus.getSecondBase())
        .addValue("third_base", baseStatus.getThirdBase());
    return jdbcTemplate.update(BaseStatusQuery.UPDATE_BASE_STATUS, sqlParameterSource);
  }

  public int createNewBaseStatus(HalfInning halfInning) {
    SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("half_inning_id", halfInning.getId());
    return jdbcTemplate
        .update(BaseStatusQuery.CREATE_NEW_BASE_STATUS, sqlParameterSource);
  }
}
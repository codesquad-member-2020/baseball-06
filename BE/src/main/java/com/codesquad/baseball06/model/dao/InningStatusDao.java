package com.codesquad.baseball06.model.dao;

import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.query.UpdateInningStatusQuery;
import com.codesquad.baseball06.model.type.BattingResult;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class InningStatusDao {

  private final NamedParameterJdbcTemplate jdbcTemplate;

  public InningStatusDao(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public int createNewInningStatus(HalfInning halfInning) {
    SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("half_inning_id", halfInning.getId());
    return jdbcTemplate
        .update(UpdateInningStatusQuery.CREATE_NEW_INNING_STATUS, sqlParameterSource);
  }

  public int updatePitchingResult(HalfInning halfInning, BattingResult battingResult) {
    SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("half_inning_id", halfInning.getId());

    if (battingResult == BattingResult.STRIKE) {
      return jdbcTemplate.update(UpdateInningStatusQuery.INCREASE_STRIKE_COUNT, sqlParameterSource);
    }
    if (battingResult == BattingResult.BALL) {
      return jdbcTemplate.update(UpdateInningStatusQuery.INCREASE_BALL_COUNT, sqlParameterSource);
    }
    if (battingResult == BattingResult.HIT) {
      return jdbcTemplate.update(UpdateInningStatusQuery.INITIALIZE_ALL_COUNT, sqlParameterSource);
//      return updateBaseStatusResult(battingResult);
    }
    if (battingResult == BattingResult.BASE_ON_BALL) {
      return jdbcTemplate.update(UpdateInningStatusQuery.INITIALIZE_ALL_COUNT, sqlParameterSource);
//      return updateBaseStatusResult(battingResult);
    }
    if (battingResult == BattingResult.OUT) {
      return jdbcTemplate.update(UpdateInningStatusQuery.INCREASE_OUT_COUNT_AND_INITIALIZE_OTHERS,
          sqlParameterSource);
    }
    if (battingResult == BattingResult.END) {
      // return jdbcTemplate.update(UpdateInningStatusQuery.INITIALIZE_ALL_COUNT, sqlParameterSource);
    }

    throw new RuntimeException("무엇인가가 잘못되었습니다.");
  }

//  public int updateBaseStatusResult(BattingResult battingResult) {
//    //insert your code here
//  }
}

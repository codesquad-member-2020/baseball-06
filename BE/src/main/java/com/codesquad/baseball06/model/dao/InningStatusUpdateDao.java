package com.codesquad.baseball06.model.dao;

import com.codesquad.baseball06.dto.UpdatedBasemanDto;
import com.codesquad.baseball06.dto.UpdatedPlayerDto;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.query.UpdateInningStatusQuery;
import com.codesquad.baseball06.model.type.BattingResult;
import com.codesquad.baseball06.model.type.PlayerType;
import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class InningStatusUpdateDao {

  private final NamedParameterJdbcTemplate jdbcTemplate;
  private final InningStatusDtoReturnDao inningStatusDtoReturnDao;

  public InningStatusUpdateDao(NamedParameterJdbcTemplate jdbcTemplate,
      InningStatusDtoReturnDao inningStatusDtoReturnDao) {
    this.jdbcTemplate = jdbcTemplate;
    this.inningStatusDtoReturnDao = inningStatusDtoReturnDao;
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
      jdbcTemplate.update(UpdateInningStatusQuery.INITIALIZE_ALL_COUNT, sqlParameterSource);
      return updateBaseStatusResult(halfInning);
    }
    if (battingResult == BattingResult.BASE_ON_BALL) {
      jdbcTemplate.update(UpdateInningStatusQuery.INITIALIZE_ALL_COUNT, sqlParameterSource);
      return updateBaseStatusResult(halfInning);
    }
    if (battingResult == BattingResult.OUT) {
      return jdbcTemplate.update(UpdateInningStatusQuery.INCREASE_OUT_COUNT_AND_INITIALIZE_OTHERS,
          sqlParameterSource);
    }
    if (battingResult == BattingResult.END) {
      jdbcTemplate.update(UpdateInningStatusQuery.INITIALIZE_ALL_COUNT, sqlParameterSource);
      // return
    }

    throw new RuntimeException("무엇인가가 잘못되었습니다.");
  }

  public int updateBaseStatusResult(HalfInning halfInning) {
    List<UpdatedPlayerDto> getPreviousPlayers = inningStatusDtoReturnDao
        .getUpdatedPlayers(halfInning.getGameId());
    UpdatedBasemanDto getPreviousBaseman = inningStatusDtoReturnDao.getUpdatedBaseman();
    SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("half_inning_id", halfInning.getId())
        .addValue("first_base", getPreviousPlayers.get(PlayerType.BATTER.getCode()))
        .addValue("second_base", getPreviousBaseman.getFirstBase().getId())
        .addValue("third_base", getPreviousBaseman.getSecondBase().getId());

    return jdbcTemplate.update(UpdateInningStatusQuery.UPDATE_INNING_PLAYER, sqlParameterSource);
  }

  public int createNewBaseStatus(Long halfInningId) {
    SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("half_inning_id", halfInningId);

    return jdbcTemplate.update(UpdateInningStatusQuery.CREATE_NEW_BASE_STATUS, sqlParameterSource);
  }
}

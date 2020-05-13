package com.codesquad.baseball06.model.dao;

import com.codesquad.baseball06.dto.UpdatedBasemanDto;
import com.codesquad.baseball06.dto.UpdatedPlayerDto;
import com.codesquad.baseball06.model.dao.mapper.LastBatterIndexMapper;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.query.UpdateInningStatusQuery;
import com.codesquad.baseball06.model.query.UpdatePlateAppearanceQuery;
import com.codesquad.baseball06.model.type.BattingResult;
import com.codesquad.baseball06.model.type.PlayerType;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class InningStatusAndPlateAppearanceUpdateDao {

  private final NamedParameterJdbcTemplate jdbcTemplate;
  private final InningStatusAndPlateAppearanceDtoReturnDao inningStatusAndPlateAppearanceDtoReturnDao;
  private final LastBatterIndexMapper lastBatterIndexMapper;

  public InningStatusAndPlateAppearanceUpdateDao(NamedParameterJdbcTemplate jdbcTemplate,
      InningStatusAndPlateAppearanceDtoReturnDao inningStatusAndPlateAppearanceDtoReturnDao,
      LastBatterIndexMapper lastBatterIndexMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.inningStatusAndPlateAppearanceDtoReturnDao = inningStatusAndPlateAppearanceDtoReturnDao;
    this.lastBatterIndexMapper = lastBatterIndexMapper;
  }

  public int createNewInningStatus(HalfInning halfInning) {
    SqlParameterSource inningStatusSource = new MapSqlParameterSource()
        .addValue("half_inning_id", halfInning.getId());
    return jdbcTemplate
        .update(UpdateInningStatusQuery.CREATE_NEW_INNING_STATUS, inningStatusSource);
  }

  public int initializePlateAppearance() {
    //1회 초의 PlateAppearance를 만듭니다.
  }

  public int createNewPlateAppearance(HalfInning halfInning) {
    //1회 말부터의 새로운 PlateAppearance를 만듭니다.
    Long veryLastBaseman = inningStatusAndPlateAppearanceDtoReturnDao.getUpdatedBaseman().getThirdBase().getId();

    SqlParameterSource plateAppearanceSource = new MapSqlParameterSource()
        .addValue("half_inning_id", halfInning.getId())
        .addValue("pitcher", 1L)
        .addValue("batter", veryLastBaseman)
        .addValue("batter_index", getLateBatterIndex())
        .addValue("result", null)
        .addValue("end", false);

    return jdbcTemplate
        .update(UpdatePlateAppearanceQuery.CREATE_NEW_PLATE_APPEARANCE, plateAppearanceSource);
  }

  public Long getLateBatterIndex() {
    Long lateBatterIndex;

    try {
      lateBatterIndex = jdbcTemplate
          .query(UpdatePlateAppearanceQuery.GET_LAST_BATTER_INDEX_BY_HALF_INNING_ID,
              lastBatterIndexMapper).get(0);
    } catch (IndexOutOfBoundsException| EmptyResultDataAccessException e) {
      lateBatterIndex = 0L;
    }

    return lateBatterIndex;
  }

  public int updatePitchingResult(HalfInning halfInning, BattingResult battingResult) {
    SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("half_inning_id", halfInning.getId());

    if (battingResult == BattingResult.STRIKE) {
      //TODO: DETAIL_PLATE_APPEARANCE 추가
      return jdbcTemplate.update(UpdateInningStatusQuery.INCREASE_STRIKE_COUNT, sqlParameterSource);
    }
    if (battingResult == BattingResult.BALL) {
      //TODO: DETAIL_PLATE_APPEARANCE 추가
      return jdbcTemplate.update(UpdateInningStatusQuery.INCREASE_BALL_COUNT, sqlParameterSource);
    }
    if (battingResult == BattingResult.HIT) {
      //TODO: PLATE_APPEARANCE 추가
      jdbcTemplate.update(UpdateInningStatusQuery.INITIALIZE_ALL_COUNT, sqlParameterSource);
      return updateBaseStatusResult(halfInning);
    }
    if (battingResult == BattingResult.BASE_ON_BALL) {
      //TODO: PLATE_APPEARANCE 추가
      jdbcTemplate.update(UpdateInningStatusQuery.INITIALIZE_ALL_COUNT, sqlParameterSource);
      return updateBaseStatusResult(halfInning);
    }
    if (battingResult == BattingResult.OUT) {
      //TODO: PLATE_APPEARANCE 추가
      return jdbcTemplate.update(UpdateInningStatusQuery.INCREASE_OUT_COUNT_AND_INITIALIZE_OTHERS,
          sqlParameterSource);
    }
    if (battingResult == BattingResult.END) {
      //TODO: PLATE_APPEARANCE 추가
      jdbcTemplate.update(UpdateInningStatusQuery.INITIALIZE_ALL_COUNT, sqlParameterSource);
      return makeEndTrueAfterInningEnds(halfInning.getId());
    }

    throw new RuntimeException("무엇인가가 잘못되었습니다.");
  }

  public int updateBaseStatusResult(HalfInning halfInning) {
    List<UpdatedPlayerDto> getPreviousPlayers = inningStatusAndPlateAppearanceDtoReturnDao
        .getUpdatedPlayers(halfInning.getGameId());
    UpdatedBasemanDto getPreviousBaseman = inningStatusAndPlateAppearanceDtoReturnDao.getUpdatedBaseman();
    SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("half_inning_id", halfInning.getId())
        .addValue("first_base", getPreviousPlayers.get(PlayerType.BATTER.getCode()))
        .addValue("second_base", getPreviousBaseman.getFirstBase().getId())
        .addValue("third_base", getPreviousBaseman.getSecondBase().getId());

    return jdbcTemplate.update(UpdateInningStatusQuery.UPDATE_INNING_PLAYER, sqlParameterSource);
  }

  public int updatePlateAppearanceAfterHitOrBaseOnBall(BattingResult battingResult, Long halfInningId) {
    Long veryLastBaseman = inningStatusAndPlateAppearanceDtoReturnDao.getUpdatedBaseman().getThirdBase().getId();

    //기존 것을 업데이트
    SqlParameterSource plateAppearanceSource = new MapSqlParameterSource()
        .addValue("half_inning_id", halfInningId)
        .addValue("pitcher", 1L)
        .addValue("batter", veryLastBaseman)
        .addValue("batter_index", getLateBatterIndex())
        .addValue("result", battingResult.getCode())
        .addValue("end", true);

    return jdbcTemplate
        .update(UpdatePlateAppearanceQuery.CREATE_NEW_PLATE_APPEARANCE, plateAppearanceSource);
  }

  public int createNewBaseStatus(Long halfInningId) {
    SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("half_inning_id", halfInningId);

    return jdbcTemplate.update(UpdateInningStatusQuery.CREATE_NEW_BASE_STATUS, sqlParameterSource);
  }

  public int makeEndTrueAfterInningEnds(Long halfInningId) {
    SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
        .addValue("half_inning_id", halfInningId);

    return jdbcTemplate
        .update(UpdateInningStatusQuery.UPDATE_END_TO_TRUE_AFTER_INNING_ENDS, sqlParameterSource);
  }

}

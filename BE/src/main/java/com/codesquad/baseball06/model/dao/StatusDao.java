package com.codesquad.baseball06.model.dao;

import static com.codesquad.baseball06.model.query.InningStatus.BASEMAN_SQL;
import static com.codesquad.baseball06.model.query.InningStatus.INNING_STATUS;
import static com.codesquad.baseball06.model.query.Test.BASEMAN_SQL_TEST;
import static com.codesquad.baseball06.model.query.Test.GAME_SQL_TEST;
import static com.codesquad.baseball06.model.query.Test.INNINGSTATUS_SQL_TEST;
import static com.codesquad.baseball06.model.query.Test.SCORE_SQL_TEST;

import com.codesquad.baseball06.dto.ScoreDto;
import com.codesquad.baseball06.dto.UpdatedBasemanDto;
import com.codesquad.baseball06.model.dao.mapper.BasemanStatusMapper;
import com.codesquad.baseball06.model.dao.mapper.BatterMapper;
import com.codesquad.baseball06.model.dao.mapper.InningIndexTypeMapper;
import com.codesquad.baseball06.model.dao.mapper.PitcherMapper;
import com.codesquad.baseball06.model.dao.mapper.InningStatusMapper;
import com.codesquad.baseball06.model.dao.mapper.ScoreMapper;
import com.codesquad.baseball06.model.entity.InningStatus;
import com.codesquad.baseball06.model.query.Inning;
import com.codesquad.baseball06.model.type.InningType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class StatusDao {

  private static final Logger log = LoggerFactory.getLogger(PlayerDao.class);
  private final NamedParameterJdbcTemplate jdbcTemplate;
  private final PitcherMapper pitcherMapper;
  private final BatterMapper batterMapper;
  private final InningStatusMapper inningStatusMapper;
  private final BasemanStatusMapper basemanStatusMapper;
  private final ScoreMapper scoreMapper;
  private final InningIndexTypeMapper inningIndexTypeMapper;

  public StatusDao(NamedParameterJdbcTemplate jdbcTemplate, PitcherMapper pitcherMapper,
      BatterMapper batterMapper,
      InningStatusMapper inningStatusMapper,
      BasemanStatusMapper basemanStatusMapper,
      ScoreMapper scoreMapper,
      InningIndexTypeMapper inningIndexTypeMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.pitcherMapper = pitcherMapper;
    this.batterMapper = batterMapper;
    this.inningStatusMapper = inningStatusMapper;
    this.basemanStatusMapper = basemanStatusMapper;
    this.scoreMapper = scoreMapper;
    this.inningIndexTypeMapper = inningIndexTypeMapper;
  }

  public void InitForTest() {

    //update inningStatus
    SqlParameterSource countParameters = new MapSqlParameterSource()
        .addValue("strike_count", 1)
        .addValue("ball_count", 2)
        .addValue("out_count", 1)
        .addValue("half_inning_id", 1);

    jdbcTemplate.update(INNINGSTATUS_SQL_TEST, countParameters);

    //update baseMan
    SqlParameterSource baseParameters = new MapSqlParameterSource()
        .addValue("first_base", 3)
        .addValue("second_base", 4)
        .addValue("third_base", 5)
        .addValue("half_inning_id", 1);

    jdbcTemplate.update(BASEMAN_SQL_TEST, baseParameters);

    //update Score
    SqlParameterSource awayParameters = new MapSqlParameterSource()
        .addValue("game_id", 1)
        .addValue("inning_index", 1)
        .addValue("type", 0)
        .addValue("score", 2)
        .addValue("end", 1);

    jdbcTemplate.update(SCORE_SQL_TEST, awayParameters);

    SqlParameterSource homeParameters = new MapSqlParameterSource()
        .addValue("game_id", 1)
        .addValue("inning_index", 1)
        .addValue("type", 1)
        .addValue("score", 3)
        .addValue("end", 1);

    jdbcTemplate.update(SCORE_SQL_TEST, homeParameters);

    //update Game
    String gameSql = "INSERT INTO game (home, away, home_user, away_user, end)" +
        "VALUES (:home, :away, :home_user, :away_user, :end)";

    SqlParameterSource gameParameters = new MapSqlParameterSource()
        .addValue("home", 3)
        .addValue("away", 2)
        .addValue("home_user", "sigrid@naver.com")
        .addValue("away_user", "dan@gmail.com")
        .addValue("end", 0);

    jdbcTemplate.update(GAME_SQL_TEST, gameParameters);
  }

  public InningStatus getInningStatus() {
    return jdbcTemplate.query(INNING_STATUS, inningStatusMapper).get(0);
  }

  public UpdatedBasemanDto getUpdatedBaseman() {
    return jdbcTemplate.query(BASEMAN_SQL, basemanStatusMapper).get(0);
  }

  public ScoreDto getScores(Long game_id) throws Exception {

    SqlParameterSource gameParameters = new MapSqlParameterSource()
        .addValue("game_id", game_id);

    Map<String, Integer> scoreMap = jdbcTemplate
        .queryForObject(Inning.GET_TEAM_SCORES, gameParameters, scoreMapper);
    Map<String, Integer> statusList = jdbcTemplate
        .queryForObject(Inning.GET_INNING_INDEX_AND_TYPE, gameParameters, inningIndexTypeMapper);

    return ScoreDto.create(
        Objects.requireNonNull(scoreMap).get("home"),
        scoreMap.get("away"),
        Objects.requireNonNull(statusList).get("inning_index"),
        InningType.findType(statusList.get("type"))
    );
  }

//  public boolean getUpdatedPitcher() {
//  }
//
//  public boolean getUpdatedBatter() {
//  }
}
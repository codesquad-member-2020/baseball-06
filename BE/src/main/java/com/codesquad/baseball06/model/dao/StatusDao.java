package com.codesquad.baseball06.model.dao;

import com.codesquad.baseball06.model.dao.mapper.BatterMapper;
import com.codesquad.baseball06.model.dao.mapper.PitcherMapper;
import com.codesquad.baseball06.model.dao.mapper.StatusMapper;
import java.util.Map;
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
  private final StatusMapper statusMapper;

  public StatusDao(NamedParameterJdbcTemplate jdbcTemplate, PitcherMapper pitcherMapper,
      BatterMapper batterMapper,
      StatusMapper statusMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.pitcherMapper = pitcherMapper;
    this.batterMapper = batterMapper;
    this.statusMapper = statusMapper;
  }

  public void InitForTest() {

    //update inningStatus
    String inningStatusSql = "INSERT INTO inning_status (strike_count, ball_count, out_count) " +
        "VALUES (:strike_count, :ball_count, :out_count)";

    SqlParameterSource countParameters = new MapSqlParameterSource()
        .addValue("strike_count", 1)
        .addValue("ball_count", 2)
        .addValue("out_count", 1);

    jdbcTemplate.update(inningStatusSql, countParameters);

    //update baseMan
    String baseManSql = "INSERT INTO base_status (first_base, second_base, third_base) " +
        "VALUES (:first_base, :second_base, :third_base)";

    SqlParameterSource baseParameters = new MapSqlParameterSource()
        .addValue("first_base", 3)
        .addValue("second_base", 4)
        .addValue("third_base", 5);

    jdbcTemplate.update(baseManSql, baseParameters);

    //update Score
    String scoreSql = "INSERT INTO half_inning (game_id, inning_index, type, score, end) " +
        "VALUES (:id, :game_id, :inning_index, :type, :score, :end)";

    SqlParameterSource awayParameters = new MapSqlParameterSource()
        .addValue("game_id", 1)
        .addValue("inning_index", 1)
        .addValue("type", 0)
        .addValue("score", 2)
        .addValue("end", 1);

    jdbcTemplate.update(scoreSql, awayParameters);

    SqlParameterSource homeParameters = new MapSqlParameterSource()
        .addValue("game_id", 1)
        .addValue("inning_index", 1)
        .addValue("type", 1)
        .addValue("score", 3)
        .addValue("end", 1);

    jdbcTemplate.update(scoreSql, homeParameters);

    //update Game
    String gameSql = "INSERT INTO game (home, away, home_user, away_user, end)" +
        "VALUES (:home, :away, :home_user, :away_user, :end)";

    SqlParameterSource gameParameters = new MapSqlParameterSource()
        .addValue("home", null)
        .addValue("away", null)
        .addValue("home_user", "sigrid@naver.com")
        .addValue("away_user", "dan@gmail.com")
        .addValue("end", 0);

    jdbcTemplate.update(gameSql, gameParameters);
  }
}

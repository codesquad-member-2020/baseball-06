package com.codesquad.baseball06.dao;

import com.codesquad.baseball06.dao.mapper.BatterReturnDtoMapper;
import com.codesquad.baseball06.dao.mapper.PitcherReturnDtoMapper;
import com.codesquad.baseball06.dto.BatterReturnDto;
import com.codesquad.baseball06.dto.PitcherReturnDto;
import com.codesquad.baseball06.model.Batter;
import com.codesquad.baseball06.model.Pitcher;
import com.codesquad.baseball06.model.Player;
import com.codesquad.baseball06.model.Team;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDao {

  private final NamedParameterJdbcTemplate jdbcTemplate;
  private final PitcherReturnDtoMapper pitcherReturnDtoMapper = new PitcherReturnDtoMapper();
  private final BatterReturnDtoMapper batterReturnDtoMapper = new BatterReturnDtoMapper();

  public PlayerDao(DataSource dataSource) {
    this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }

  public PitcherReturnDto findPitcherById(Long id) {

    String sql = "SELECT * FROM player p WHERE p.id = :id";
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("id", id);
    return jdbcTemplate.queryForObject(sql, namedParameters, pitcherReturnDtoMapper);
  }

  public BatterReturnDto findBatterById(Long id) {

    String sql = "SELECT * FROM player p WHERE p.id = :id";
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("id", id);
    return jdbcTemplate.queryForObject(sql, namedParameters, batterReturnDtoMapper);
  }

  public void insertPlayer(int team_id, int type, String name, double batting_average) {

    //TODO: int type일 때 tinyint로 제한하는 방법?
    String sql = "INSERT INTO player (team_id, type, name, batting_average)"
        + " VALUES (:team_id, :type, :name, :batting_average)";
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("team_id", team_id)
        .addValue("type", type)
        .addValue("name", name)
        .addValue("batting_average", batting_average);
    jdbcTemplate.update(sql, namedParameters);
  }
}
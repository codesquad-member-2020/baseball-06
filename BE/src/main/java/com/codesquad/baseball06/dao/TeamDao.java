package com.codesquad.baseball06.dao;

import com.codesquad.baseball06.dto.TeamReturnDto;
import com.codesquad.baseball06.model.Batter;
import com.codesquad.baseball06.model.Pitcher;
import com.codesquad.baseball06.model.Team;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class TeamDao {

  private static final Logger logger = LoggerFactory.getLogger(TeamDao.class);
  private final JdbcTemplate jdbcTemplate;
  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  public TeamDao(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
    namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
  }

  public TeamReturnDto findTeamById(Long id) {

    String teamSql = "SELECT * FROM team t WHERE t.id = ?";
    String playerSql = "SELECT * FROM player p WHERE p.type = ? AND p.team_id = ?";
    int pitcherMagicIndex = 0;
    int batterMagicIndex = 1;

    List<Pitcher> pitcherList = jdbcTemplate
        .queryForList(playerSql, new Object[]{pitcherMagicIndex, id}, Pitcher.class);
    List<Batter> batterList = jdbcTemplate
        .queryForList(playerSql, new Object[]{batterMagicIndex, id}, Batter.class);

    TeamReturnDto teamReturnDto = Optional.ofNullable(jdbcTemplate.queryForObject(teamSql, new Object[]{id},
        (rs, numRow)
            -> TeamReturnDto.create(
            rs.getLong("id"), rs.getString("name"), pitcherList, batterList)
    )).orElseThrow(NullPointerException::new);

    return teamReturnDto;
  }

  public void insertTeam(Team team) {

    String sql = "INSERT INTO team (name)" +
        "VALUES (:name)";
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("name", team.getName());
    namedParameterJdbcTemplate.update(sql, namedParameters);
  }
}
package com.codesquad.baseball06.model.dao;

import com.codesquad.baseball06.model.entity.Batter;
import com.codesquad.baseball06.model.entity.Pitcher;
import com.codesquad.baseball06.model.entity.Player;
import com.codesquad.baseball06.model.type.PlayerType;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDao {

  private static final Logger log = LoggerFactory.getLogger(PlayerDao.class);

  private final NamedParameterJdbcTemplate jdbcTemplate;

  private final RowMapper<? extends Player> playerMapper = ((rs, rowNum) -> {
    if (rs.getInt(3) == PlayerType.PITCHER.getCode()) {
      return Pitcher.create(rs.getLong(1), rs.getLong(2), rs.getString(4));
    }
    return Batter.create(rs.getLong(1), rs.getLong(2), rs.getString(4), rs.getDouble(5));
  });

  public PlayerDao(NamedParameterJdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public Optional<? extends Player> findPlayerById(Long id) {
    String sql = new StringBuilder()
        .append("SELECT p.id, p.team_id, p.type, p.name, p.batting_average ")
        .append("FROM player p ")
        .append("WHERE p.id = :id").toString();
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("id", id);

    return Optional.ofNullable(jdbcTemplate.queryForObject(sql, namedParameters, playerMapper));
  }
}

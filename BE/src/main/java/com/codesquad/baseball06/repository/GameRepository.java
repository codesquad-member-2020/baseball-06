package com.codesquad.baseball06.repository;

import com.codesquad.baseball06.model.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository {

  private final Logger logger = LoggerFactory.getLogger(GameRepository.class);
  private final JdbcTemplate jdbcTemplate;

  private final RowMapper<Game> gameMapper = ((rs, rowNum) ->
      Game.create(rs.getLong(1)
          , rs.getInt(2)
          , rs.getInt(3)
          , rs.getString(4)
          , rs.getString(5)
          , rs.getBoolean(6)
          , rs.getTimestamp(7)
      ));

  public GameRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public Game findGameById(Long id) {
    String query = new StringBuilder()
        .append("SELECT g.id, g.away, g.home, g.away_user, g.home_user, g.end, g.created_at ")
        .append("FROM game g ")
        .append("WHERE g.id =?").toString();
    return jdbcTemplate.query(query, new Object[]{id}, gameMapper).get(0);
  }
}

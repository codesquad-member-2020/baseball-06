package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.model.dao.TeamDao;
import com.codesquad.baseball06.model.entity.Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class GameMapper implements RowMapper<List<Game>> {

  private final TeamDao teamDao;

  public GameMapper(TeamDao teamDao) {
    this.teamDao = teamDao;
  }

  @Override
  public List<Game> mapRow(ResultSet rs, int rowNum) throws SQLException {
    List<Game> gameList = new ArrayList<>();

    do {
      Long awayId = rs.getLong("away_id");
      Long homeId = rs.getLong("home_id");
      gameList.add(Game.create(rs.getLong("id")
          , teamDao.findTeamById(awayId)
          , teamDao.findTeamById(homeId)
          , rs.getString("away_user")
          , rs.getString("home_user")
          , rs.getBoolean("end")
          , rs.getTimestamp("created_at")));
    } while (rs.next());

    return gameList;
  }
}

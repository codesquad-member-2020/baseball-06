package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.model.dao.HalfInningDao;
import com.codesquad.baseball06.model.dao.TeamDao;
import com.codesquad.baseball06.model.entity.Game;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.type.InningType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class GameMapper implements RowMapper<List<Game>> {

  private final TeamDao teamDao;
  private final HalfInningDao halfInningDao;

  public GameMapper(TeamDao teamDao, HalfInningDao halfInningDao) {
    this.teamDao = teamDao;
    this.halfInningDao = halfInningDao;
  }

  @Override
  public List<Game> mapRow(ResultSet rs, int rowNum) throws SQLException {
    List<Game> gameList = new ArrayList<>();

    do {
      Long awayId = rs.getLong("away_id");
      Long homeId = rs.getLong("home_id");
      Long gameId = rs.getLong("id");
      List<HalfInning> halfInningList = halfInningDao.findHalfInningByGameId(gameId);
      List<HalfInning> earlyInningList = halfInningList.stream()
          .filter(halfInning -> halfInning.getType().equals(InningType.EARLY))
          .collect(Collectors.toList());
      List<HalfInning> lateInningList = halfInningList.stream()
          .filter(halfInning -> halfInning.getType().equals(InningType.LATE)).collect(
              Collectors.toList());

      gameList.add(Game.create(gameId,
          teamDao.findTeamById(awayId),
          teamDao.findTeamById(homeId),
          rs.getString("away_user"),
          rs.getString("home_user"),
          rs.getBoolean("end"),
          rs.getTimestamp("created_at"),
          earlyInningList,
          lateInningList));
    } while (rs.next());

    return gameList;
  }
}

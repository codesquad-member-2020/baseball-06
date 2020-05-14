package com.codesquad.baseball06.model.dao.mapper.unused;

import com.codesquad.baseball06.model.dao.unused.PlayerDao;
import com.codesquad.baseball06.model.entity.Team;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper implements RowMapper<List<Team>> {

  private final PlayerDao playerDao;

  public TeamMapper(PlayerDao playerDao) {
    this.playerDao = playerDao;
  }

  @Override
  public List<Team> mapRow(ResultSet rs, int rowNum) throws SQLException {
    List<Team> teamList = new ArrayList<>();

    do {
      Long teamId = rs.getLong("id");
      teamList.add(Team.create(teamId, rs.getString("name"), playerDao.findPitcherAndTeamId(teamId),
          playerDao.findBatterByTeamId(teamId)));
    } while (rs.next());

    return teamList;
  }
}

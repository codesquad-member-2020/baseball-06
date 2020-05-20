package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.model.entity.Team;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class EachTeamMapper implements RowMapper<Team> {

  private final PlayerDao playerDao;

  public EachTeamMapper(PlayerDao playerDao) {
    this.playerDao = playerDao;
  }

  @Override
  public Team mapRow(ResultSet rs, int rowNum) throws SQLException {

    Long teamId = rs.getLong("id");
    return Team.create(teamId,
        rs.getString("name"),
        playerDao.findPitcherByTeamId(teamId),
        playerDao.findBatterByTeamId(teamId)
    );
  }
}

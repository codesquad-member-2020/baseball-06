package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.model.dao.BaseStatusDao;
import com.codesquad.baseball06.model.dao.InningStatusDao;
import com.codesquad.baseball06.model.entity.HalfInning;
import com.codesquad.baseball06.model.type.InningType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class HalfInningMapper implements RowMapper<List<HalfInning>> {

  private final InningStatusDao inningStatusDao;
  private final BaseStatusDao baseStatusDao;

  public HalfInningMapper(InningStatusDao inningStatusDao,
      BaseStatusDao baseStatusDao) {
    this.inningStatusDao = inningStatusDao;
    this.baseStatusDao = baseStatusDao;
  }

  @Override
  public List<HalfInning> mapRow(ResultSet rs, int rowNum) throws SQLException {
    List<HalfInning> halfInnings = new ArrayList<>();

    do {
      InningType type;
      if (rs.getBoolean("type")) {
        type = InningType.LATE;
      } else {
        type = InningType.EARLY;
      }

      Long inningId = rs.getLong("id");

      halfInnings.add(HalfInning.create(
          inningId,
          rs.getLong("game_id"),
          rs.getInt("inning_index"),
          type,
          rs.getInt("score"),
          rs.getBoolean("end"),
          rs.getTimestamp("created_at").toLocalDateTime(),
          inningStatusDao.findInningStatusByInningId(inningId),
          baseStatusDao.getBaseStatus(inningId)));
    } while (rs.next());

    return halfInnings;
  }
}

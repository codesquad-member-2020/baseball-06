package com.codesquad.baseball06.model.dao.mapper;

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

      halfInnings.add(HalfInning.create(
          rs.getLong("id")
          , rs.getLong("game_id")
          , rs.getInt("inning_index")
          , type
          , rs.getInt("score")
          , rs.getBoolean("end")
          , rs.getTimestamp("created_at").toLocalDateTime()));
    } while (rs.next());

    return halfInnings;
  }
}

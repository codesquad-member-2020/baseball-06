package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.model.entity.Batter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class BatterMapper implements RowMapper<List<Batter>> {

  @Override
  public List<Batter> mapRow(ResultSet rs, int rowNum) throws SQLException {
    List<Batter> batterList = new ArrayList<>();

    do {
      batterList.add(Batter.create(
          rs.getLong("id"),
          rs.getLong("team_id"),
          rs.getString("name"),
          rs.getDouble("batting_average"))
      );
    } while (rs.next());

    return batterList;
  }
}

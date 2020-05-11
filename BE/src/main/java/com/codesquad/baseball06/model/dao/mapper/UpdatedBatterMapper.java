package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.model.entity.Batter;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UpdatedBatterMapper implements RowMapper<Batter> {

  @Override
  public Batter mapRow(ResultSet rs, int rowNum) throws SQLException {

    return Batter.create(
        rs.getLong("id"),
        rs.getLong("team_id"),
        rs.getString("name"),
        rs.getDouble("batting_average"),
        rs.getInt("batter_index")
    );
  }
}

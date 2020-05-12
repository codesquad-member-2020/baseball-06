package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.model.entity.Pitcher;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UpdatedPitcherMapper implements RowMapper<Pitcher> {

  @Override
  public Pitcher mapRow(ResultSet rs, int rowNum) throws SQLException {

    return Pitcher.create(
        rs.getLong("id"),
        rs.getLong("team_id"),
        rs.getString("name")
    );
  }
}

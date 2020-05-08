package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.model.entity.Pitcher;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SinglePitcherMapper implements RowMapper<Pitcher> {

  @Override
  public Pitcher mapRow(ResultSet rs, int rowNum) throws SQLException {
    return Pitcher.create(rs.getLong(1), rs.getLong(2), rs.getString(4));
  }
}

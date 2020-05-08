package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.model.entity.Batter;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SingleBatterMapper implements RowMapper<Batter> {

  @Override
  public Batter mapRow(ResultSet rs, int rowNum) throws SQLException {
    return Batter.create(rs.getLong(1), rs.getLong(2), rs.getString(4), rs.getDouble(5));
  }
}

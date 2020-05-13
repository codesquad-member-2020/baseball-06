package com.codesquad.baseball06.model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class LastBatterIndexMapper implements RowMapper<Long> {

  @Override
  public Long mapRow(ResultSet rs, int rowNum) throws SQLException {

    return rs.getLong("batter_index");
  }
}

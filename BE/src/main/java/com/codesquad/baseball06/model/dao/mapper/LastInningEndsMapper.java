package com.codesquad.baseball06.model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class LastInningEndsMapper implements RowMapper<Boolean> {

  @Override
  public Boolean mapRow(ResultSet rs, int rowNum) throws SQLException {

    return rs.getBoolean("end");
  }
}

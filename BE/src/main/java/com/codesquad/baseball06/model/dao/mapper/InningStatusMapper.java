package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.model.entity.InningStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class InningStatusMapper implements RowMapper<InningStatus> {

  @Override
  public InningStatus mapRow(ResultSet rs, int rowNum) throws SQLException {

    return InningStatus
        .create(
            rs.getLong("id"),
            rs.getLong("half_inning_id"),
            rs.getInt("strike_count"),
            rs.getInt("ball_count"),
            rs.getInt("out_count")
        );
  }
}

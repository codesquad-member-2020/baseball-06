package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.model.entity.BaseStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class BaseStatusMapper implements RowMapper<BaseStatus> {

  @Override
  public BaseStatus mapRow(ResultSet rs, int rowNum) throws SQLException {

    return BaseStatus.create(
        rs.getLong("id"),
        rs.getLong("half_inning_id"),
        rs.getBoolean("first_base"),
        rs.getBoolean("second_base"),
        rs.getBoolean("third_base")
    );
  }
}

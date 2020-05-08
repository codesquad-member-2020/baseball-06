package com.codesquad.baseball06.dao.mapper;

import com.codesquad.baseball06.dto.BatterReturnDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BatterReturnDtoMapper implements RowMapper<BatterReturnDto> {

  @Override
  public BatterReturnDto mapRow(ResultSet rs, int rowNum) throws SQLException {
    int PITCHER_MAGIC_INDEX = 0;
    if (rs.getInt("type") == PITCHER_MAGIC_INDEX) {
      throw new SQLException();
    }
    return BatterReturnDto
        .create(rs.getLong("id"), rs.getString("name"), rs.getDouble("battingAverage"),
            rs.getLong("team_id"));
  }
}

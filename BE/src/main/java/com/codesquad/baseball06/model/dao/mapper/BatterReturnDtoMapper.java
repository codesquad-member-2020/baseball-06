package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.dto.BatterReturnDto;
import com.codesquad.baseball06.model.type.PlayerType;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BatterReturnDtoMapper implements RowMapper<BatterReturnDto> {

  @Override
  public BatterReturnDto mapRow(ResultSet rs, int rowNum) throws SQLException {
    if (PlayerType.BATTER.getCode() != rs.getInt("type")) {
      throw new SQLException();
    }
    return BatterReturnDto
        .create(rs.getLong("id"), rs.getString("name"), rs.getDouble("battingAverage"),
            rs.getLong("team_id"));
  }
}

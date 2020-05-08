package com.codesquad.baseball06.dao.mapper;

import com.codesquad.baseball06.dto.PitcherReturnDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PitcherReturnDtoMapper implements RowMapper<PitcherReturnDto> {

  @Override
  public PitcherReturnDto mapRow(ResultSet rs, int rowNum) throws SQLException {
    int BATTER_MAGIC_INDEX = 1;
    if (rs.getInt("type") != BATTER_MAGIC_INDEX) {
      throw new SQLException();
    }
    return PitcherReturnDto.create(rs.getLong("id"), rs.getString("name"), rs.getLong("team_id"));
  }
}

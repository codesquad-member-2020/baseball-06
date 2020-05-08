package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.dto.PitcherReturnDto;
import com.codesquad.baseball06.model.type.PlayerType;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PitcherReturnDtoMapper implements RowMapper<PitcherReturnDto> {

  @Override
  public PitcherReturnDto mapRow(ResultSet rs, int rowNum) throws SQLException {
    if (PlayerType.PITCHER.getCode() != rs.getInt("type")) {
      throw new SQLException();
    }

    return PitcherReturnDto.create(rs.getLong("id"), rs.getString("name"), rs.getLong("team_id"));
  }
}

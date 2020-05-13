package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.dto.RawPlateAppearanceDto;
import com.codesquad.baseball06.model.entity.PlateAppearance;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class RawPlateAppearanceDtoMapper implements RowMapper<List<RawPlateAppearanceDto>> {

  @Override
  public List<RawPlateAppearanceDto> mapRow(ResultSet rs, int rowNum) throws SQLException {

    List<RawPlateAppearanceDto> plateAppearanceDtoList = new ArrayList<>();

    do {
      RawPlateAppearanceDto rawPlateAppearanceDto = RawPlateAppearanceDto.create(
          rs.getLong("id"),
          rs.getLong("half_inning_id"),
          rs.getLong("pitcher"),
          rs.getLong("batter"),
          rs.getInt("batter_index"),
          rs.getInt("result"),
          rs.getTimestamp("created_at"),
          rs.getBoolean("end")
      );
      plateAppearanceDtoList.add(rawPlateAppearanceDto);
    } while (rs.next());

    return plateAppearanceDtoList;
  }
}

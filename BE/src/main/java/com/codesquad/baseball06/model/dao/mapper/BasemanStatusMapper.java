package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.dto.UpdatedBasemanDto;
import com.codesquad.baseball06.dto.UpdatedBasemanDto.SpecificBasemanDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class BasemanStatusMapper implements RowMapper<UpdatedBasemanDto> {

  @Override
  public UpdatedBasemanDto mapRow(ResultSet rs, int rowNum) throws SQLException {

    List<SpecificBasemanDto> tempList = new ArrayList<>();

    do {
      SpecificBasemanDto basemanDto = SpecificBasemanDto
          .create(rs.getString("name"), rs.getLong("id"));
      tempList.add(basemanDto);
    } while (rs.next());

    return UpdatedBasemanDto.create(tempList.get(0), tempList.get(1), tempList.get(2));
  }
}

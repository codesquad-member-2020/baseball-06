package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.model.entity.Pitcher;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class PitcherMapper implements RowMapper<List<Pitcher>> {

  @Override
  public List<Pitcher> mapRow(ResultSet rs, int rowNum) throws SQLException {
    List<Pitcher> pitcherList = new ArrayList<>();

    do {
      pitcherList.add(Pitcher.create(rs.getLong(1), rs.getLong(2), rs.getString(4)));
    } while (rs.next());

    return pitcherList;
  }
}

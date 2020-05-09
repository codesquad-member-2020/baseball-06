package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.model.entity.Batter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class BatterMapper implements RowMapper<List<Batter>> {

  @Override
  public List<Batter> mapRow(ResultSet rs, int rowNum) throws SQLException {
    List<Batter> batterList = new ArrayList<>();

    do {
      batterList.add(Batter.create(rs.getLong(1), rs.getLong(2), rs.getString(4), rs.getDouble(5)));
    } while (rs.next());

    return batterList;
  }
}

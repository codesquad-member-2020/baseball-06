package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.model.entity.BaseStatus;
import com.codesquad.baseball06.model.entity.Batter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class BaseStatusMapper implements RowMapper<List<BaseStatus>> {

  @Override
  public List<BaseStatus> mapRow(ResultSet rs, int rowNum) throws SQLException {

    List<BaseStatus> baseStatusList = new ArrayList<>();

    do {
      baseStatusList.add(
          BaseStatus.create(
              rs.getLong("id"),
              rs.getLong("half_inning_id"),
              rs.getBoolean("first_base"),
              rs.getBoolean("second_base"),
              rs.getBoolean("third_base"))
      );
    } while (rs.next());

    return baseStatusList;
  }
}

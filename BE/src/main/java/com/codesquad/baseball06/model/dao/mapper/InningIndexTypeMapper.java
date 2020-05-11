package com.codesquad.baseball06.model.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class InningIndexTypeMapper implements RowMapper<Map<String, Integer>> {

  @Override
  public Map<String, Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {
    HashMap<String, Integer> indexTypeMap = new HashMap<>();

    indexTypeMap.put("inning_index", rs.getInt("inning_index"));
    indexTypeMap.put("type", rs.getInt("type"));

    return indexTypeMap;
  }
}

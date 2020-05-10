package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.dto.ScoreDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class ScoreMapper implements RowMapper<Map<String, Integer>> {

  @Override
  public Map<String, Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {

    Map<String, Integer> scoreMap = new HashMap<>();

    do {
      if (rs.getLong("id") == 1) {
        scoreMap.put("away", rs.getInt("score"));
      }
      if (rs.getLong("id") == 2) {
        scoreMap.put("home", rs.getInt("score"));
      }
    } while (rs.next());

    return scoreMap;
  }
}

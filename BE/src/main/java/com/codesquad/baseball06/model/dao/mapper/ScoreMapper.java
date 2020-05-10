package com.codesquad.baseball06.model.dao.mapper;

import com.codesquad.baseball06.dto.ScoreDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class ScoreMapper implements RowMapper<List<Integer>> {

  @Override
  public List<Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {

    List<Integer> scoreList = new ArrayList<>();

    do {
      int nowScore = rs.getInt("score");
      scoreList.add(nowScore);
    } while (rs.next());

    return scoreList;
  }
}

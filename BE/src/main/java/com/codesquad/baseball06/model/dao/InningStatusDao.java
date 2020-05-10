package com.codesquad.baseball06.model.dao;

import static com.codesquad.baseball06.model.query.InningStatus.FIND_BY_ID;
import static com.codesquad.baseball06.model.query.InningStatus.INSERT;

import com.codesquad.baseball06.model.dao.mapper.InningStatusMapper;
import com.codesquad.baseball06.model.entity.InningStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class InningStatusDao {

  private static final Logger logger = LoggerFactory.getLogger(TeamDao.class);
  private final NamedParameterJdbcTemplate jdbcTemplate;
  private final InningStatusMapper inningStatusMapper;

  public InningStatusDao(NamedParameterJdbcTemplate jdbcTemplate,
      InningStatusMapper inningStatusMapper) {
    this.jdbcTemplate = jdbcTemplate;
    this.inningStatusMapper = inningStatusMapper;
  }

  public InningStatus findHalfInningById(Long id) {
    SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);

    return jdbcTemplate.queryForObject(FIND_BY_ID, namedParameters, inningStatusMapper)
        .get(0);
  }

  public int create(Long halfInningId) {
    SqlParameterSource namedParameters = new MapSqlParameterSource()
        .addValue("half_inning_id", halfInningId);

    return jdbcTemplate.update(INSERT, namedParameters);
  }
}

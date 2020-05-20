package com.codesquad.baseball06.model.dao.unused;

import org.springframework.stereotype.Repository;

@Repository
public class InningStatusDtoReturnDao {
//
//  private static final Logger log = LoggerFactory.getLogger(PlayerDao.class);
//  private final NamedParameterJdbcTemplate jdbcTemplate;
//  private final InningStatusMapper inningStatusMapper;
//  private final BaseStatusMapper baseStatusMapper;
//  private final ScoreMapper scoreMapper;
//  private final InningIndexTypeMapper inningIndexTypeMapper;
//
//  public InningStatusDtoReturnDao(NamedParameterJdbcTemplate jdbcTemplate,
//      InningStatusMapper inningStatusMapper,
//      BaseStatusMapper baseStatusMapper,
//      ScoreMapper scoreMapper,
//      InningIndexTypeMapper inningIndexTypeMapper) {
//    this.jdbcTemplate = jdbcTemplate;
//    this.inningStatusMapper = inningStatusMapper;
//    this.baseStatusMapper = baseStatusMapper;
//    this.scoreMapper = scoreMapper;
//    this.inningIndexTypeMapper = inningIndexTypeMapper;
//  }
//
//  public void InitForTest() {
//
//    //update inningStatus
//    SqlParameterSource countParameters = new MapSqlParameterSource()
//        .addValue("strike_count", 1)
//        .addValue("ball_count", 2)
//        .addValue("out_count", 1)
//        .addValue("half_inning_id", 1);
//
//    jdbcTemplate.update(INNINGSTATUS_SQL_TEST, countParameters);
//
//    //update baseMan
//    SqlParameterSource baseParameters = new MapSqlParameterSource()
//        .addValue("first_base", 3)
//        .addValue("second_base", 4)
//        .addValue("third_base", 5)
//        .addValue("half_inning_id", 1);
//
//    jdbcTemplate.update(BASEMAN_SQL_TEST, baseParameters);
//
//    //update Score
//    SqlParameterSource awayParameters = new MapSqlParameterSource()
//        .addValue("game_id", 1)
//        .addValue("inning_index", 1)
//        .addValue("type", 0)
//        .addValue("score", 2)
//        .addValue("end", 1);
//
//    jdbcTemplate.update(SCORE_SQL_TEST, awayParameters);
//
//    SqlParameterSource homeParameters = new MapSqlParameterSource()
//        .addValue("game_id", 1)
//        .addValue("inning_index", 1)
//        .addValue("type", 1)
//        .addValue("score", 3)
//        .addValue("end", 1);
//
//    jdbcTemplate.update(SCORE_SQL_TEST, homeParameters);
//
//    //updated PlateAppearance
//    SqlParameterSource plateParameters = new MapSqlParameterSource()
//        .addValue("half_inning_id", 1)
//        .addValue("pitcher", 1)
//        .addValue("batter", 3)
//        .addValue("batter_index", 1)
//        .addValue("result", 0)
//        .addValue("end", 0);
//
//    jdbcTemplate.update(PLATE_SQL_TEST, plateParameters);
//
//    //update GameQuery
//    SqlParameterSource gameParameters = new MapSqlParameterSource()
//        .addValue("home_id", 3)
//        .addValue("away_id", 2)
//        .addValue("home_user", "sigrid@naver.com")
//        .addValue("away_user", "dan@gmail.com")
//        .addValue("end", 0);
//
//    jdbcTemplate.update(GAME_SQL_TEST, gameParameters);
//  }
//
//  public InningStatus getInningStatus() {
//    //TODO: 왜 get(0)이 두 개지..
//    List<InningStatus> inningStatus = jdbcTemplate.query(INNING_STATUS, inningStatusMapper).get(0);
//    return inningStatus.get(0);
//  }
//
//  public UpdatedBasemanDto getUpdatedBaseman() {
//    try {
//      return jdbcTemplate.query(BASEMAN_SQL, baseStatusMapper).get(0);
//    } catch (IndexOutOfBoundsException | EmptyResultDataAccessException e) {
//      return UpdatedBasemanDto.create(null, null, null);
//    }
//  }
//
//  public ScoreDto getScores(Long game_id) throws Exception {
//
//    SqlParameterSource gameParameters = new MapSqlParameterSource()
//        .addValue("game_id", game_id);
//
//    Map<String, Integer> scoreMap = jdbcTemplate
//        .queryForObject(InningStatusQuery.GET_TEAM_SCORES, gameParameters, scoreMapper);
//    Map<String, Integer> statusList = jdbcTemplate
//        .queryForObject(InningStatusQuery.GET_INNING_INDEX_AND_TYPE, gameParameters,
//            inningIndexTypeMapper);
//
//    return ScoreDto.create(
//        Objects.requireNonNull(scoreMap).get("home"),
//        scoreMap.get("away"),
//        Objects.requireNonNull(statusList).get("inning_index"),
//        InningType.findType(statusList.get("type"))
//    );
//  }
//
//  public List<UpdatedPlayerDto> getUpdatedPlayers(Long game_id) {
//
//    SqlParameterSource gameParameters = new MapSqlParameterSource()
//        .addValue("game_id", game_id);
//
//    Batter updatedBatter = jdbcTemplate
//        .queryForObject(PlayerQuery.FIND_CURRENT_BATTER, gameParameters, new BatterMapper()).get(0);
//    Pitcher updatedPitcher = jdbcTemplate
//        .queryForObject(PlayerQuery.FIND_CURRENT_PITCHER, gameParameters, new PitcherMapper())
//        .get(0);
//
//    List<UpdatedPlayerDto> playerDtoList = new ArrayList<>();
//    playerDtoList
//        .add(UpdatedPlayerDto.createUpdatedBatterDto(Objects.requireNonNull(updatedBatter)));
//    playerDtoList.add(UpdatedPlayerDto.createUpdatedPitcherDto(
//        Objects.requireNonNull(updatedPitcher)));
//
//    return playerDtoList;
//  }
}

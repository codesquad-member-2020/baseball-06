//package com.codesquad.baseball06.model.dao;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
//
//import com.codesquad.baseball06.model.dao.PlayerDaoTest;
//import com.codesquad.baseball06.model.entity.Team;
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.dao.EmptyResultDataAccessException;
//
//@SpringBootTest
//class TeamDaoTest {
//
//  private static final Logger log = LoggerFactory.getLogger(PlayerDaoTest.class);
//
//  @Autowired
//  private TeamDao teamDao;
//
//  @Test
//  void findTeamById() {
//    assertThat(teamDao.findTeamById(2L))
//        .isNotNull()
//        .isInstanceOf(Team.class);
//  }
//
//  @Test
////  void findTeamById_null() {
////    assertThatExceptionOfType(EmptyResultDataAccessException.class)
////        .isThrownBy(() -> teamDao.findTeamById(999L));
////  }
//}

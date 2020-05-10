package com.codesquad.baseball06.model.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InningStatusDaoTest {

  @Autowired
  InningStatusDao inningStatusDao;

  @Test
  void findHalfInningById() {
    Assertions.assertThat(inningStatusDao.create(1L))
        .isOne();

    Assertions.assertThat(inningStatusDao.findHalfInningById(1L))
        .isNotNull();
  }

  @Test
  void create() {
    Assertions.assertThat(inningStatusDao.create(1L))
        .isOne();
  }
}

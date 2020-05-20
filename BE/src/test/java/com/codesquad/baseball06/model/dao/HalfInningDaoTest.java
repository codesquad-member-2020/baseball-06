package com.codesquad.baseball06.model.dao;

import com.codesquad.baseball06.model.type.InningType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HalfInningDaoTest {

  @Autowired
  HalfInningDao halfInningDao;

  @Test
  void create() {
    Assertions.assertThat(halfInningDao.addNewHalfInning(1L, 1, InningType.EARLY))
        .isOne();
  }

  @Test
  void findHalfInningById() {
    Assertions.assertThat(halfInningDao.addNewHalfInning(1L, 1, InningType.EARLY))
        .isOne();

    Assertions.assertThat(halfInningDao.findHalfInningById(1L))
        .isNotNull();
  }
}

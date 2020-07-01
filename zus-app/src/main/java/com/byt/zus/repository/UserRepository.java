package com.byt.zus.repository;

import com.byt.zus.dao.tables.daos.UserDao;
import com.byt.zus.dao.tables.pojos.User;
import org.jooq.impl.DefaultDSLContext;

import static com.byt.zus.dao.tables.User.USER;

public class UserRepository extends UserDao {

  private final DefaultDSLContext dsl;

  public UserRepository(final DefaultDSLContext dsl) {

    super(dsl.configuration());
    this.dsl = dsl;
  }

  public Long insertIntoReturningId(final User user) {

    return dsl.insertInto(USER)
              .set(dsl.newRecord(USER, user))
              .returning(USER.ID)
              .fetchOne()
              .into(User.class)
              .getId();
  }
}

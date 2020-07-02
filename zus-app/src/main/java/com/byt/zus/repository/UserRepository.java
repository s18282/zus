package com.byt.zus.repository;

import com.byt.zus.dao.UserStatus;
import com.byt.zus.dao.tables.daos.UserDao;
import com.byt.zus.dao.tables.pojos.User;
import org.jooq.impl.DefaultDSLContext;

import java.util.Optional;

import static com.byt.zus.dao.tables.User.USER;

public class UserRepository extends UserDao {

  private final DefaultDSLContext dsl;

  public UserRepository(final DefaultDSLContext dsl) {

    super(dsl.configuration());
    this.dsl = dsl;
  }

  public Optional<User> findByName(String username) {

    return Optional.ofNullable((User) dsl.select()
            .from(USER)
            .where(USER.NAME.eq(username))
            .fetchInto(User.class));
  }

  public Long insertIntoReturningId(final User user) {

    return dsl.insertInto(USER)
              .set(dsl.newRecord(USER, user))
              .returning(USER.ID)
              .fetchOne()
              .into(User.class)
              .getId();
  }

  public UserStatus findStatusById(final Long id) {

    return dsl.select(USER.USER_STATUS)
        .from(USER)
        .where(USER.ID.eq(id))
        .fetchOneInto(UserStatus.class);
  }

  public void updateUserStatus(final Long idToUpdate, final UserStatus userStatus) {

    dsl.update(USER)
        .set(USER.USER_STATUS, userStatus)
        .where(USER.ID.eq(idToUpdate))
        .execute();
  }
}

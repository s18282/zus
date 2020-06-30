package com.byt.zus.repository;

import com.balaur.zus.dao.tables.daos.FileDao;
import com.balaur.zus.dao.tables.pojos.File;
import com.balaur.zus.dao.tables.pojos.User;
import org.jooq.impl.DefaultDSLContext;

import static com.balaur.zus.dao.tables.File.FILE;

public class FileRepository extends FileDao {

  private final DefaultDSLContext dsl;

  public FileRepository(final DefaultDSLContext dsl)  {

    super(dsl.configuration());
    this.dsl = dsl;
  }

  public Long insertIntoReturningId(final File file) {

    return dsl.insertInto(FILE)
              .set(dsl.newRecord(FILE, file))
              .returning(FILE.ID)
              .fetchOne()
              .into(User.class)
              .getId();
  }
}

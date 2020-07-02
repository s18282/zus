package com.byt.zus.repository;

import com.byt.zus.dao.tables.daos.FileDao;
import com.byt.zus.dao.tables.pojos.File;
import com.byt.zus.dao.tables.pojos.User;
import org.jooq.impl.DefaultDSLContext;

import java.util.List;

import static com.byt.zus.dao.tables.File.FILE;

public class FileRepository extends FileDao {

  private final DefaultDSLContext dsl;

  public FileRepository(final DefaultDSLContext dsl) {

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

  public List<String> getAllFilesUri() {

    return dsl.selectFrom(FILE)
              .fetch(FILE.URL);
  }

  public boolean updateFile(final Long id, final String newUrl) {

    dsl.update(FILE)
       .set(FILE.URL, newUrl)
       .where(FILE.ID.eq(id))
       .execute();
    return dsl.fetchExists(FILE, FILE.URL.contains(newUrl));
  }
}

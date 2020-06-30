package com.byt.zus;

import com.byt.zus.dao.InMemoryDaoTest;
import com.byt.zus.service.FileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = ZusTestConfiguration.class)
@RunWith(SpringRunner.class)
@ActiveProfiles({"test"})
public class FileTests extends InMemoryDaoTest {

  @Autowired
  private FileService fileService;

  @Test
  public void insertNewFile() {

    //given
    final String url = "example_url";

    //when
    final Long id1 = fileService.insertIntoReturningId(url);
    final Long id2 = fileService.insertIntoReturningId(url);
    final Long id3 = fileService.insertIntoReturningId(url);

    //then
    assertEquals(id1, Long.valueOf(1));
    assertEquals(id2, Long.valueOf(2));
    assertEquals(id3, Long.valueOf(3));
  }
}

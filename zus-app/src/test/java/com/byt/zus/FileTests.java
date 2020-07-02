package com.byt.zus;

import com.byt.zus.dao.InMemoryDaoTest;
import com.byt.zus.service.FileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.event.annotation.AfterTestClass;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = ZusTestConfiguration.class)
@RunWith(SpringRunner.class)
@ActiveProfiles({"test"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
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
    assertEquals(Long.valueOf(1), id1);
    assertEquals(Long.valueOf(2), id2);
    assertEquals(Long.valueOf(3), id3);
  }

  @Test
  public void getAll() {

      //before
//      assertEquals(fileService.getAllFiles().size(), 0);

      //given
      final String url = "example_url";

      //when
      fileService.insertIntoReturningId(url);
      fileService.insertIntoReturningId(url);
      fileService.insertIntoReturningId(url);

      //then
      assertEquals(fileService.getAllFiles().size(), 3);
  }
}

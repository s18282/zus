package com.byt.zus;

import com.byt.zus.dao.UserStatus;
import com.byt.zus.dao.tables.pojos.User;
import com.byt.zus.service.FileService;
import com.byt.zus.service.UserService;
import com.byt.zus.service.UserStatusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = ZusTestConfiguration.class)
@RunWith(SpringRunner.class)
@ActiveProfiles({"test"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserStatusTests {

  @Autowired
  private UserService userService;

  @Autowired
  private UserStatusService userStatusService;

  @Test
  public void changeUserStatus() {

    //given
    final User adminUser = userService.findById(1);
    final long newUserId = userService.insertIntoReturningId(new User(2L, "Andrzej", "Kowalski", true, UserStatus.USER));

    //when
    userStatusService.updateUserStatus(1L, newUserId, UserStatus.EDITOR);

    //then
    final User changedUser = userService.findById(2L);
    assertEquals(UserStatus.EDITOR, changedUser.getUserStatus());
  }
}

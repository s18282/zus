package com.byt.zus;

import com.byt.zus.dao.InMemoryDaoTest;
import com.byt.zus.dao.tables.pojos.User;
import com.byt.zus.service.UserService;
import lombok.var;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ContextConfiguration(classes = ZusTestConfiguration.class)
@RunWith(SpringRunner.class)
@ActiveProfiles({"test"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserTests extends InMemoryDaoTest {

    @Autowired
    private UserService userService;

    @Test
    public void shouldCreateUserAndLoginSuccessfully() {

        //given
        var username = "Marian";
        var password = "Paździoch";
        var id = 1L;

        //when
        userService.insertIntoReturningId(new User(null, username, password, true));
        long userId = userService.loginReturningId(new User(null, username, password, true));

        //then
        assertEquals(id, userId);
    }

}

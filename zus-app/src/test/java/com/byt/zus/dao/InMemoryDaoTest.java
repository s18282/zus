package com.byt.zus.dao;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {
    InMemoryJooqConfiguration.class
})
@ActiveProfiles("test")
abstract public class InMemoryDaoTest {

}

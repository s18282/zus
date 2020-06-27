package com.byt.zus;

import com.byt.zus.repository.UserRepository;
import com.byt.zus.service.UserService;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZusConfiguration {

  @Bean
  UserRepository userRepository(final DefaultDSLContext dsl) {

    return new UserRepository(dsl);
  }

  @Bean
  UserService userService(final UserRepository userRepository) {

    return new UserService(userRepository);
  }
}

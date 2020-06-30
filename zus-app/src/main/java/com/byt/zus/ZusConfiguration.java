package com.byt.zus;

import com.byt.zus.repository.FileRepository;
import com.byt.zus.repository.UserRepository;
import com.byt.zus.repository.WorkflowStepRepository;
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
  WorkflowStepRepository workflowStepRepository(final DefaultDSLContext dsl) {

    return new WorkflowStepRepository(dsl);
  }

  @Bean
  FileRepository fileRepository(final DefaultDSLContext dsl) {

    return new FileRepository(dsl);
  }
}

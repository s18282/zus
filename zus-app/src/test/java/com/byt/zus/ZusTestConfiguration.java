package com.byt.zus;

import com.byt.zus.repository.FileRepository;
import com.byt.zus.repository.UserRepository;
import com.byt.zus.repository.WorkflowStepRepository;
import com.byt.zus.service.FileService;
import com.byt.zus.service.UserService;
import com.byt.zus.service.WorkflowStepService;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDataSourceConfiguration;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({EmbeddedDataSourceConfiguration.class, FlywayAutoConfiguration.class, JooqAutoConfiguration.class})
public class ZusTestConfiguration {

  @Bean
  FileRepository fileRepository(final DefaultDSLContext dsl) {

    return new FileRepository(dsl);
  }

  @Bean
  FileService fileService(final FileRepository fileRepository) {

    return new FileService(fileRepository);
  }

  @Bean
  UserRepository userRepository(final DefaultDSLContext dsl) {

    return new UserRepository(dsl);
  }

  @Bean
  UserService userService(final UserRepository userRepository) {

    return new UserService(userRepository);
  }


  @Bean
  WorkflowStepRepository workflowStepRepository(final DefaultDSLContext dsl) {

    return new WorkflowStepRepository(dsl);
  }

  @Bean
  WorkflowStepService workflowStepService(final WorkflowStepRepository workflowStepRepository) {

    return new WorkflowStepService(workflowStepRepository);
  }

}

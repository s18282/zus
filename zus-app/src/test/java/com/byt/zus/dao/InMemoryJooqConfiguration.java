package com.byt.zus.dao;

import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDataSourceConfiguration;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({EmbeddedDataSourceConfiguration.class, FlywayAutoConfiguration.class, JooqAutoConfiguration.class})
@Configuration
class InMemoryJooqConfiguration {

}

package com.byt.zus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ZusConfiguration.class)
public class ZusApplication {

  public static void main(String[] args) {

    SpringApplication.run(ZusApplication.class, args);
  }
}

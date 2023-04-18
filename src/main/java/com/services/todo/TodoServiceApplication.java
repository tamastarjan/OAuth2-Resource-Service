package com.services.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TodoServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(TodoServiceApplication.class, args);
  }

}

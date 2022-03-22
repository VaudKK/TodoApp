package com.practice.todos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class TodosApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodosApplication.class, args);
    }

}

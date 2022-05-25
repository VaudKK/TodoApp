package com.practice.todos.repositories;

import com.practice.todos.models.Todos;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

public interface TodosRepository extends ReactiveMongoRepository<Todos,String> {

    Flux<Todos> findByDueDate(LocalDateTime localDateTime);



}

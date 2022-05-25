package com.practice.todos.services;

import com.practice.todos.models.Todos;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public interface TodosService {

    Mono<Todos> createTodo(String task);

    Flux<Todos> getAllTodos();

    Flux<Todos> getTodoByDate(LocalDateTime localDateTime);

    Mono<Todos> setDoneStatus(String uuid,Boolean isDone);

}

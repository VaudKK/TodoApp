package com.practice.todos.services;

import com.practice.todos.models.Todos;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TodosService {

    Mono<Todos> createTodo(String task);

    Flux<Todos> getAllTodos();

}

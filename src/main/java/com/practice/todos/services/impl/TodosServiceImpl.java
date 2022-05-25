package com.practice.todos.services.impl;

import com.practice.todos.models.Todos;
import com.practice.todos.repositories.TodosRepository;
import com.practice.todos.services.TodosService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class TodosServiceImpl implements TodosService {

    private final TodosRepository todosRepository;

    public TodosServiceImpl(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    @Override
    public Mono<Todos> createTodo(String task) {
        Todos todo = new Todos();
        todo.setTask(task);
        return todosRepository.save(todo);
    }

    @Override
    public Flux<Todos> getAllTodos() {
        return todosRepository.findAll();
    }

    @Override
    public Flux<Todos> getTodoByDate(LocalDateTime localDateTime) {
        return todosRepository.findByDueDate(localDateTime);
    }

    @Override
    public Mono<Todos> setDoneStatus(String uuid,Boolean isDone) {
        return todosRepository.findById(uuid)
                .doOnNext(todo -> todo.setDone(isDone))
                .flatMap(todosRepository::save)
                .switchIfEmpty(Mono.empty());
    }
}

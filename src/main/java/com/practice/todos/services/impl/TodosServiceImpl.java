package com.practice.todos.services.impl;

import com.practice.todos.exceptions.TodoException;
import com.practice.todos.models.Todos;
import com.practice.todos.repositories.TodosRepository;
import com.practice.todos.services.TodosService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Service
public class TodosServiceImpl implements TodosService {

    private final TodosRepository todosRepository;

    public TodosServiceImpl(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    @Override
    public Mono<Todos> createTodo(String task, String dueDate) {

        if(dueDate != null){
            if(!isDateValid(dueDate,DateTimeFormatter.ofPattern("dd/MM/yyyy"))){
                throw new TodoException("Incorrect date format. Expected format is dd/MM/yyy");
            }
        }

        Todos todo = new Todos();
        todo.setTask(task);
        todo.setDueDate(dueDate == null ? LocalDate.now() : LocalDate.parse(dueDate,DateTimeFormatter.ofPattern("dd/MM/yyyy")));
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

    @Override
    public Mono<Todos> closeTodo(String uuid) {
        return todosRepository.findById(uuid)
                .doOnNext(todo -> todo.setClosed(true))
                .flatMap(todosRepository::save)
                .switchIfEmpty(Mono.empty());
    }


    private boolean isDateValid(String date, DateTimeFormatter dateTimeFormatter){
        try{
            dateTimeFormatter.parse(date);
            return true;
        }catch (DateTimeParseException e){
            return false;
        }
    }
}

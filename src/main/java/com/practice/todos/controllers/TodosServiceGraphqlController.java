package com.practice.todos.controllers;

import com.practice.todos.models.Todos;
import com.practice.todos.services.TodosService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class TodosServiceGraphqlController {

    private final TodosService todosService;


    public TodosServiceGraphqlController(TodosService todosService) {
        this.todosService = todosService;
    }


    @MutationMapping("addTodo")
    public Mono<Todos> addTodo(@Argument String task){
        return todosService.createTodo(task);
    }

    @MutationMapping("setDoneStatus")
    public Mono<Todos> setDoneStatus(@Argument String uuid,@Argument Boolean done){
        return todosService.setDoneStatus(uuid,done);
    }

    @QueryMapping("getAllTodos")
    public Flux<Todos> getAllTodos(){
        return todosService.getAllTodos();
    }
}

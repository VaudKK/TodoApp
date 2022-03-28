package com.practice.todos.repositories;

import com.practice.todos.models.Todos;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TodosRepository extends ReactiveMongoRepository<Todos,String> {
}

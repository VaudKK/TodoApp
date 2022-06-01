package com.practice.todos.models;

import com.practice.todos.enums.Priority;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document
public class Todos {

    @Id
    private String _id;

    private String task;

    private String notes;

    private Priority priority = Priority.NONE;

    private LocalDate dueDate;

    private LocalDateTime createdAt = LocalDateTime.now();

    private Boolean closed = false;

    private Boolean done = false;

}

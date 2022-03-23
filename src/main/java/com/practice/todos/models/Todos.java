package com.practice.todos.models;

import com.practice.todos.enums.Priority;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Todos {

    @Id
    private String id;

    private String task;

    private String notes;

    private Priority priority;

    private LocalDateTime dueDate;

    private LocalDateTime createdAt;

    private Boolean closed;

    private Boolean done;

}

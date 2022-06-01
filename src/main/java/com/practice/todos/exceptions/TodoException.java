package com.practice.todos.exceptions;

public class TodoException extends  RuntimeException{

    public TodoException(String message) {
        super(message);
    }

    public TodoException(String message, Throwable cause) {
        super(message, cause);
    }
}

package com.todolist.Common.Errors;

public class Errors {
    private String message;

    public Errors(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

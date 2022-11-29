package com.todolist.Entities;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_todo")
    private String nameTodo;
    @Column(name = "is_completed")
    private boolean isCompleted;

    public Todo() {

    }

    public Todo(long id, String nameTodo, boolean isCompleted) {
        super();
        this.id = id;
        this.nameTodo = nameTodo;
        this.isCompleted = isCompleted;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameTodo() {
        return nameTodo;
    }

    public void setNameTodo(String nameTodo) {
        this.nameTodo = nameTodo;
    }

    public boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean completed) {
        isCompleted = completed;
    }
}

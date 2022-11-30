package com.todolist.API;

import com.todolist.Common.Errors.Errors;
import com.todolist.DAO.TodoRepository;
import com.todolist.Entities.Todo;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @PostMapping("/todo")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            return ResponseEntity.of(todo);
        }
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo, @PathVariable Long id) {
        Optional<Todo> todoToFind = todoRepository.findById(id);
        if (todoToFind.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else {
            Todo todoToUpdate = todoToFind.get();

            todoToUpdate.setNameTodo(todo.getNameTodo());
            todoToUpdate.setIsCompleted(todo.getIsCompleted());
            todoRepository.save(todoToUpdate);

            return ResponseEntity.of(todoToFind);
        }
    }

    //@DeleteMapping("/todos/{id}")
    //public ResponseEntity<> deleteTodo() {

    //}
}

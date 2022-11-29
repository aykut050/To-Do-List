package com.todolist.API;

import com.todolist.DAO.TodoRepository;
import com.todolist.Entities.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

}

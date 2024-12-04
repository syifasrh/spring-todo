package com.example.todo_app.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_app.models.Todo;
import com.example.todo_app.services.TodoServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "*")
public class TodoController {
    private final TodoServices todoServices;

    // Constructor Injection
    public TodoController(TodoServices todoServices) {
        this.todoServices = todoServices;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoServices.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoServices.getTodoById(id);
    }

    @PostMapping
    public Todo createTodo(@Valid @RequestBody Todo todo) {
        return todoServices.createTodo(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @Valid @RequestBody Todo todoDetails) {
        return todoServices.updateTodo(id, todoDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id) {
        todoServices.deleteTodo(id);
        return ResponseEntity.ok().build();
    }
}

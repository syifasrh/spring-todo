package com.example.todo_app.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.todo_app.models.Todo;
import com.example.todo_app.repositories.TodoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TodoServices {
    private final TodoRepository todoRepository;

    // Constructor Injection
    public TodoServices(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo not found with id: " + id));
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo todoDetails) {
        Todo todo = getTodoById(id);

        todo.setTitle(todo.getTitle());
        todo.setDescription(todo.getDescription());
        todo.setCompleted(todo.isCompleted());
        todo.setUpdatedAt(LocalDateTime.now());

        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        Todo todo = getTodoById(id);
        todoRepository.delete(todo);
    }
}

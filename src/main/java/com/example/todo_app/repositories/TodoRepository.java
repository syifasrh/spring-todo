package com.example.todo_app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.todo_app.models.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}

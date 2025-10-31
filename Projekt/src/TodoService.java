<<<<<<< HEAD
=======
// src/main/java/com/example/todo/service/TodoService.java
package com.example.todo.service;

import com.example.todo.model.TodoItem;
import com.example.todo.repository.TodoRepository;
>>>>>>> origin/Create-Project
import java.util.List;

public class TodoService {
    private final TodoRepository repo;

    public TodoService(TodoRepository repo) {
        this.repo = repo;
    }

    public TodoItem addTodo(String description) {
        return repo.save(description);
    }

    public List<TodoItem> getAllTodos() {
        return repo.findAll();
    }

    public void markAsDone(int id) {
        repo.findById(id).ifPresent(TodoItem::markDone);
    }
}

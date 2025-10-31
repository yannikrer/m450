<<<<<<< HEAD
=======
// src/main/java/com/example/todo/repository/TodoRepository.java
package com.example.todo.repository;

import com.example.todo.model.TodoItem;
>>>>>>> origin/Create-Project
import java.util.*;

public class TodoRepository {
    private final Map<Integer, TodoItem> store = new HashMap<>();
    private int counter = 1;

    public TodoItem save(String description) {
        TodoItem item = new TodoItem(counter++, description, false);
        store.put(item.getId(), item);
        return item;
    }

    public List<TodoItem> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<TodoItem> findById(int id) {
        return Optional.ofNullable(store.get(id));
    }
}

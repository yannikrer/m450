<<<<<<< HEAD
import TodoItem;
import TodoRepository;
=======
// src/test/java/com/example/todo/service/TodoServiceTest.java
package com.example.todo.service;

import com.example.todo.model.TodoItem;
import com.example.todo.repository.TodoRepository;
>>>>>>> origin/Create-Project
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TodoServiceTest {

    @Test
    void addTodo_createsAndReturnsTodo() {
        TodoRepository repo = mock(TodoRepository.class);
        TodoService service = new TodoService(repo);
        TodoItem expected = new TodoItem(1, "Test", false);

        when(repo.save("Test")).thenReturn(expected);

        TodoItem result = service.addTodo("Test");

        assertEquals("Test", result.getDescription());
        assertFalse(result.isDone());
        verify(repo).save("Test");
    }
}

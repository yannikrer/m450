import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TodoRepositoryTest {

    private TodoRepository repo;

    @BeforeEach
    void setup() {
        repo = new TodoRepository();
    }

    @Test
    void save_createsItemsWithIncrementingIds() {
        TodoItem first = repo.save("Einkaufen");
        TodoItem second = repo.save("Wäsche waschen");

        assertNotEquals(first.getId(), second.getId());
        assertEquals("Einkaufen", first.getDescription());
        assertFalse(first.isDone());
    }

    @Test
    void findAll_returnsAllItems() {
        repo.save("A");
        repo.save("B");

        List<TodoItem> todos = repo.findAll();
        assertEquals(2, todos.size());
    }

    @Test
    void findById_returnsItemWhenExists() {
        TodoItem created = repo.save("Programmieren lernen");
        Optional<TodoItem> result = repo.findById(created.getId());

        assertTrue(result.isPresent());
        assertEquals(created.getId(), result.get().getId());
    }

    @Test
    void findById_emptyWhenMissing() {
        Optional<TodoItem> result = repo.findById(99);
        assertTrue(result.isEmpty());
    }
}

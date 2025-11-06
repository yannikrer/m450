import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

class TodoRepositoryTest {

    private TodoRepository repo;

    @BeforeEach
    void setUp() {
        repo = new TodoRepository();
    }

    @Test
    void save_createsTodoWithIncrementingId() {
        TodoItem first = repo.save("Einkaufen");
        TodoItem second = repo.save("Wäsche waschen");

        assertEquals(1, first.getId(), "Erstes Todo sollte ID 1 haben");
        assertEquals(2, second.getId(), "Zweites Todo sollte ID 2 haben");
        assertEquals("Einkaufen", first.getDescription());
        assertFalse(first.isDone());
    }

    @Test
    void findAll_returnsAllSavedTodos() {
        repo.save("Einkaufen");
        repo.save("Putzen");

        List<TodoItem> todos = repo.findAll();

        assertEquals(2, todos.size(), "Es sollten 2 Todos vorhanden sein");
        assertTrue(todos.stream().anyMatch(t -> t.getDescription().equals("Einkaufen")));
    }

    @Test
    void findById_returnsCorrectTodo() {
        TodoItem created = repo.save("Programmieren lernen");
        Optional<TodoItem> result = repo.findById(created.getId());

        assertTrue(result.isPresent());
        assertEquals("Programmieren lernen", result.get().getDescription());
    }

    @Test
    void findById_returnsEmptyIfNotExists() {
        Optional<TodoItem> result = repo.findById(99);
        assertTrue(result.isEmpty(), "Nicht existierende ID sollte leeres Optional liefern");
    }

    @Test
    void findAll_returnsEmptyListInitially() {
        List<TodoItem> result = repo.findAll();
        assertTrue(result.isEmpty(), "Am Anfang sollte Liste leer sein");
    }

    @Test
    void save_addsTodoToInternalStore() {
        TodoItem item = repo.save("Test");
        Optional<TodoItem> stored = repo.findById(item.getId());

        assertTrue(stored.isPresent(), "Todo sollte im internen Speicher vorhanden sein");
        assertEquals("Test", stored.get().getDescription());
    }
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TodoServiceTest {

    private TodoRepository repo;
    private TodoService service;

    @BeforeEach
    void setUp() {
        repo = mock(TodoRepository.class);
        service = new TodoService(repo);
    }

    @Test
    void addTodo_createsAndReturnsTodo() {
        TodoItem expected = new TodoItem(1, "Test", false);
        when(repo.save("Test")).thenReturn(expected);

        TodoItem result = service.addTodo("Test");

        assertEquals("Test", result.getDescription());
        assertFalse(result.isDone());
        verify(repo).save("Test");
    }

    @Test
    void getAllTodos_returnsListFromRepository() {
        List<TodoItem> todos = List.of(
                new TodoItem(1, "A", false),
                new TodoItem(2, "B", true)
        );
        when(repo.findAll()).thenReturn(todos);

        List<TodoItem> result = service.getAllTodos();

        verify(repo).findAll();
        assertEquals(2, result.size());
        assertEquals("A", result.get(0).getDescription());
    }

    @Test
    void markAsDone_marksTodoAsDoneIfFound() {
        TodoItem item = new TodoItem(1, "Test", false);
        when(repo.findById(1)).thenReturn(Optional.of(item));

        service.markAsDone(1);

        verify(repo).findById(1);
        assertTrue(item.isDone(), "Todo sollte auf erledigt gesetzt werden");
    }

    @Test
    void markAsDone_doesNothingIfTodoNotFound() {
        when(repo.findById(99)).thenReturn(Optional.empty());

        service.markAsDone(99);

        verify(repo).findById(99);
    }

    @Test
    void addTodo_callsSaveOnce() {
        when(repo.save(anyString())).thenReturn(new TodoItem(1, "X", false));
        service.addTodo("X");
        verify(repo, times(1)).save("X");
    }
}

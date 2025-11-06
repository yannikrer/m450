import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TodoItemTest {

    @Test
    void constructorAndGettersWork() {
        TodoItem item = new TodoItem(1, "Test", false);
        assertEquals(1, item.getId());
        assertEquals("Test", item.getDescription());
        assertFalse(item.isDone());
    }

    @Test
    void markDone_setsDoneToTrue() {
        TodoItem item = new TodoItem(2, "Finish homework", false);
        assertFalse(item.isDone());
        item.markDone();
        assertTrue(item.isDone(), "markDone() sollte den Status auf true setzen");
    }
}

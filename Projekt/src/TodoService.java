
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

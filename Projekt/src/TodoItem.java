
public class TodoItem {
    private final int id;
    private final String description;
    private boolean done;

    public TodoItem(int id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public int getId() { return id; }
    public String getDescription() { return description; }
    public boolean isDone() { return done; }

    public void markDone() { this.done = true; }
}

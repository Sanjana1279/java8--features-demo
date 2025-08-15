import java.time.LocalDate;

public class Task {
    private String name;
    private LocalDate dueDate;
    private boolean completed;

    public Task(String name, LocalDate dueDate, boolean completed) {
        this.name = name;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return name + " | Due: " + dueDate + " | Completed: " + completed;
    }
}

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // DateTime API Example
        System.out.println("Today's Date: " + LocalDate.now());
        System.out.println("Current DateTime: " + LocalDateTime.now());
        System.out.println("Due date after 5 days: " + LocalDate.now().plusDays(5));

        // Creating a list of tasks
        List<Task> tasks = Arrays.asList(
                new Task("Complete Java Project", LocalDate.now().plusDays(3), false),
                new Task("Prepare Presentation", LocalDate.now().plusDays(1), true),
                new Task("Buy Groceries", LocalDate.now().plusDays(2), false),
                new Task("Pay Bills", LocalDate.now().minusDays(1), true)
        );

        // Lambda: Sorting tasks by due date
        tasks.sort((t1, t2) -> t1.getDueDate().compareTo(t2.getDueDate()));
        System.out.println("\nSorted Tasks:");
        tasks.forEach(System.out::println);

        // Streams: Filter tasks not completed
        List<Task> pendingTasks = tasks.stream()
                .filter(t -> !t.isCompleted())
                .collect(Collectors.toList());
        System.out.println("\nPending Tasks:");
        pendingTasks.forEach(System.out::println);

        // Streams: Get task names in uppercase
        List<String> taskNames = tasks.stream()
                .map(t -> t.getName().toUpperCase())
                .collect(Collectors.toList());
        System.out.println("\nTask Names in Uppercase:");
        taskNames.forEach(System.out::println);

        // Streams: Count overdue tasks
        long overdueCount = tasks.stream()
                .filter(t -> t.getDueDate().isBefore(LocalDate.now()))
                .count();
        System.out.println("\nOverdue Tasks Count: " + overdueCount);

        // Functional Interface usage
        TaskProcessor processor = task -> System.out.println("Processing Task: " + task.getName());
        System.out.println("\nProcessing all tasks:");
        tasks.forEach(processor::process);
    }
}

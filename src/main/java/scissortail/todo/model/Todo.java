package scissortail.todo.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Data
@EqualsAndHashCode(of = "id")
public class Todo {
    private UUID id;
    private String title;
    private String details;
    private LocalDate created;
    private LocalDate deadline;

    public Todo(String title, String details, LocalDate created, LocalDate deadline) {
        this.title = title;
        this.details = details;
        this.created = created;
        this.deadline = deadline;
    }
}

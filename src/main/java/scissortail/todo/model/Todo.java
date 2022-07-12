package scissortail.todo.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
public class Todo {
    @Setter(AccessLevel.NONE)
    private int id;
    private String details;
    private LocalDate created;
    private LocalDate deadline;

    public Todo(String details, LocalDate created, LocalDate deadline) {
        this.details = details;
        this.created = created;
        this.deadline = deadline;
    }
}

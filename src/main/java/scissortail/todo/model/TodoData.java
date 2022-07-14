package scissortail.todo.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.*;

public class TodoData {
    // == fields ==
    private final List<Todo> items = new ArrayList<>();

    // == constructors ==
    public TodoData() {
        addItem(new Todo("wash dog", "details todo", LocalDate.now(), LocalDate.of(2022, 10, 2)));
        addItem(new Todo("fix brakes", "details todo", LocalDate.now(), LocalDate.of(2022, 10, 9)));
        addItem(new Todo("read book", "details todo", LocalDate.now(), LocalDate.of(2022, 10, 9)));
        addItem(new Todo("grocery shop", "details todo", LocalDate.now(), LocalDate.of(2022, 10, 3)));
        for (Todo item : items) {
            System.out.println(item.getId());
        }
    }

    // == public methods ==
    public List<Todo> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull Todo item) {
        UUID id = UUID.randomUUID();
        item.setId(id);
        items.add(item);
    }

    public void removeItem(UUID id) {
        items.removeIf(todo -> todo.getId().equals(id));
    }

    public Todo getItem(UUID id) {
        for (Todo item : items) {
            if (id.equals(item.getId())) {
                return item;
            }
        }
        return null;
    }

    public void updateItem(@NonNull Todo toUpdate) {
        items.replaceAll(todo -> todo.equals(toUpdate) ? toUpdate : todo);
    }
}

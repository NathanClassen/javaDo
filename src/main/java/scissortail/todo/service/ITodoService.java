package scissortail.todo.service;

import scissortail.todo.model.Todo;
import scissortail.todo.model.TodoData;

import java.util.UUID;

public interface ITodoService {
    void addItem(Todo item);
    void removeItem(UUID id);
    void updateItem(Todo item);

    Todo getItem(UUID id);
    TodoData getData();
}

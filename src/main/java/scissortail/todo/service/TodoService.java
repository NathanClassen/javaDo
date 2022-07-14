package scissortail.todo.service;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scissortail.todo.model.Todo;
import scissortail.todo.model.TodoData;

import java.util.UUID;

@Slf4j
@Service
public class TodoService implements ITodoService {
    @Getter
    private final TodoData data;

    @Autowired
    public TodoService(TodoData todoData) {
        data = todoData;
    }

    @Override
    public void addItem(@NonNull Todo item) {
        data.addItem(item);
    }

    @Override
    public void removeItem(UUID id) {
        data.removeItem(id);
    }

    @Override
    public void updateItem(Todo item) {
        data.updateItem(item);
    }

    @Override
    public Todo getItem(UUID id) {
        return data.getItem(id);
    }
}

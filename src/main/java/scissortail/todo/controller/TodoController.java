package scissortail.todo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import scissortail.todo.model.Todo;
import scissortail.todo.model.TodoData;
import scissortail.todo.service.TodoService;
import scissortail.todo.util.AttributeNames;
import scissortail.todo.util.Mappings;
import scissortail.todo.util.ViewNames;

import java.time.LocalDate;
import java.util.UUID;

@Controller
@Slf4j
public class TodoController {
    private final TodoService todoService;
    public static final String REDIRECT = "redirect:/";

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // == model attributes ==
    @ModelAttribute
    public TodoData todoData() {
        return todoService.getData();
    }

    // == request methods ==
    // == GET ==
    @GetMapping(Mappings.ITEMS)
    public String items() {
        return ViewNames.ITEMS_LIST;
    }

    @GetMapping(Mappings.PROCESS_TODO)
    public String addEditItem(@RequestParam(required = false) String id, Model model) {
        Todo todo;
        if (id != null) {
            todo = todoService.getItem(UUID.fromString(id));
        } else {
            todo = new Todo("", "", LocalDate.now(), LocalDate.now());
        }
        model.addAttribute(AttributeNames.TODO, todo);
        return ViewNames.ADD_TODO;
    }

    @GetMapping(Mappings.TODO)
    public String todo(@RequestParam String id, Model model) {
        Todo todo = todoService.getItem(UUID.fromString(id));
        log.info("found todo: {}", todo);
        model.addAttribute(AttributeNames.TODO, todo);
        return ViewNames.TODO;
    }


    // == POST ==
    @PostMapping(Mappings.PROCESS_TODO)
    public String processItem(@ModelAttribute(AttributeNames.TODO) Todo todo) {
        if (todo.getId() != null) {
            todoService.updateItem(todo);
        } else {
            todoService.addItem(todo);
        }
        return REDIRECT + Mappings.ITEMS;
    }

    @GetMapping(Mappings.DELETE_TODO)
    public String deleteTodo(@RequestParam String id) {
        todoService.removeItem(UUID.fromString(id));
        return REDIRECT + Mappings.ITEMS;
    }
}

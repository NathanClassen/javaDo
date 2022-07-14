package scissortail.todo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import scissortail.todo.service.DemoService;
import scissortail.todo.util.Mappings;
import scissortail.todo.util.ViewNames;

@Slf4j
@Controller
public class DemoController {
    public final DemoService demoService;

    public DemoController(@Autowired DemoService demoService) {
        this.demoService = demoService;
    }

    // == model attributes ==

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {
        return demoService.getWelcomeMessage();
    }

    // == request handlers ==

    @ResponseBody
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping(Mappings.WELCOME)
    public String welcome(@RequestParam(required = false) String user, @RequestParam(required = false) Integer age, Model model) {
        String name = (user != null ? user : "New User");
        model.addAttribute("helloMessage", demoService.getHelloMessage(name));
        model.addAttribute("age", (age != null ? age : 0));
        //  return value represents the logical view name; i.e. a resolver specified in the ViewResolver
        return ViewNames.WELCOME;
    }
}

package scissortail.todo.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService implements IDemoService {
    @Override
    public String getHelloMessage(String user) {
        return "hello, " + user;
    }

    @Override
    public String getWelcomeMessage() {
        return "welcome to Scissortail demo";
    }
}

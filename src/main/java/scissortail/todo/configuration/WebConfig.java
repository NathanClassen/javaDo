package scissortail.todo.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import scissortail.todo.model.TodoData;

@Slf4j
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "scissortail.todo")
public class WebConfig {
    // == constants ==
    private static final String RESOLVER_PREFIX = "/WEB-INF/view/";
    private static final String RESOLVER_SUFFIX = ".jsp";

    // == bean methods ==
    @Bean("viewResolver")
    public ViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(RESOLVER_PREFIX);
        viewResolver.setSuffix(RESOLVER_SUFFIX);

        return viewResolver;
    }

    @Bean("todoData")
    public TodoData todoData() {
        TodoData data = new TodoData();
        return data;
    }
}

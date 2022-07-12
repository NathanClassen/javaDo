package scissortail.todo.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {
    private static final String DISPATCHER_SERVLET_NAME = "base_dispatch";
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        log.info("=== onStartup ===");

        // create Spring Application context
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();

        // registering a configuration class; our @Configuration annotated WebConfig class
        context.register(WebConfig.class);

        // create the Dispatcher Servlet
        /*
            this is the central dispatch for all registered request handlers or controllers
            it dispatches requests to these registered handlers for processing web requests, and provides a
                convenient mapping and exception handling
            it is based around a JavaBeans configuration mechanism.
            a web application can define any number of DispatcherServlets. Each servlet will operate in its own
                namespace, loading its own application context with mappings, handlers, etc.

            we are providing it with the context initialized above, which receives our WebBonfig class for
                annotation based configuration. I assume we will create controllers/handlers which will be annotated
                such that they are registered to the DispatchServlet that we create via `context`
         */
        DispatcherServlet dispatcherServlet
                = new DispatcherServlet(context);

        // register and configure the Dispatcher servlet
        /*
            based on the fact that ServletContext defines a set of methods FOR INTERACTING WITH THE SERVLET CONTAINER
                which is TomCat in our case...

                this line is doing something like telling TomCat,
                    "hey, here is a servlet class for you to run/operate. So lets register it on you, our Servlet
                        container"
         */
        ServletRegistration.Dynamic baseDispatchRegistration =
                servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);

        //  tell the container (TomCat) to instantiate and initialize our dispatcherServlet when the container starts up
        //  remember, we can do this because `baseDispatchRegistration` is returned from `servletContext.addServlet`
        //      and `servletContext` gives us methods that are used for interacting with the servlet container itself
        baseDispatchRegistration.setLoadOnStartup(1);
        //  maps the servlet to the URL pattern specified. So overrides the default TomCat homepage
        baseDispatchRegistration.addMapping("/");


    }
}

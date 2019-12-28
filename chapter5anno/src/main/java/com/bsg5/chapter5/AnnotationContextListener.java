package com.bsg5.chapter5;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.
        support.AnnotationConfigWebApplicationContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class AnnotationContextListener implements ServletContextListener {

    /**
     * Receives notification that the web application initialization
     * process is starting.
     *
     * <p>All ServletContextListeners are notified of context
     * initialization before any filters or servlets in the web
     * application are initialized.
     *
     * @param sce the ServletContextEvent containing the ServletContext
     *            that is being initialized
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ApplicationContext context = buildAnnotationContext();
        event.getServletContext().setAttribute("context", context);
    }

    private ApplicationContext buildAnnotationContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("com.bsg5.chapter3.mem03");
        context.refresh();
        return context;
    }

    /**
     * Receives notification that the ServletContext is about to be
     * shut down.
     *
     * <p>All servlets and filters will have been destroyed before any
     * ServletContextListeners are notified of context
     * destruction.
     *
     * @param sce the ServletContextEvent containing the ServletContext
     *            that is being destroyed
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

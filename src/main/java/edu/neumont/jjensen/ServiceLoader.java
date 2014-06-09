package edu.neumont.jjensen;

import edu.neumont.jjensen.model.ApplicationContext;
import edu.neumont.jjensen.model.DataAccessFactory;
import edu.neumont.jjensen.model.DataAccessLayer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by jjensen on 5/6/14.
 */

@WebListener()
public class ServiceLoader implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DataAccessLayer dal = DataAccessFactory.create("hashmap");
        ApplicationContext context = ApplicationContext.getInstance();
        context.setAttribute("dal", dal);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

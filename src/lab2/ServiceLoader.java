package lab2;

import lab2.model.DataAccessFactory;
import lab2.model.DataAccessLayer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by jjensen on 5/6/14.
 */

@WebListener()
public class ServiceLoader implements ServletContextListener {

    ServletContext context;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        DataAccessLayer dal = DataAccessFactory.create("hashmap");
        ServerContext.setAttribute("dal", dal);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}

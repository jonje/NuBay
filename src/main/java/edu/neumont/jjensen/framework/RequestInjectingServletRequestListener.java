package edu.neumont.jjensen.framework;

import javax.enterprise.context.RequestScoped;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Produces;

/**
 * Created by jjensen on 6/12/14.
 */
@WebListener
public class RequestInjectingServletRequestListener implements ServletRequestListener {
    private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<>();
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

        requestHolder.remove();

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        requestHolder.set((HttpServletRequest) servletRequestEvent.getServletRequest());

    }

    @Produces
    @RequestScoped
    public HttpServletRequest getInstance() {
        return requestHolder.get();
    }
}

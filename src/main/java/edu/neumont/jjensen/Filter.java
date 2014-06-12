package edu.neumont.jjensen;

import org.joda.time.DateTime;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;

/**
 * Created by jjensen on 6/12/14.
 */
@WebFilter("/*")
public class Filter implements javax.servlet.Filter{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(servletRequest instanceof HttpServletRequest){
            HttpServletRequest request = (HttpServletRequest)servletRequest;

            HttpSession session = request.getSession();
            DateTime createdTime = new DateTime(session.getCreationTime());
            DateTime now = DateTime.now();

            if((now.getMillis() - createdTime.getMillis()) > 100000){

                session.removeAttribute("itemsList");
            }

        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}

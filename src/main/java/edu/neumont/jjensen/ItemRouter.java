package edu.neumont.jjensen;

import edu.neumont.jjensen.controller.ItemGetController;
import edu.neumont.jjensen.controller.ItemPostController;
import edu.neumont.jjensen.model.DataAccessFactory;
import edu.neumont.jjensen.model.DataAccessLayer;
import edu.neumont.jjensen.model.Item;
import edu.neumont.jjensen.modelandview.ModelAndView;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jjensen on 4/23/14.
 */
@WebServlet("/item/*")
public class ItemRouter extends HttpServlet {
    //private static DataAccessLayer dal = DataAccessFactory.create("hashmap");

    private final static Pattern pattern = Pattern.compile("(/item)(/)([0-9]+)([/a-z]*)");
    private final static Pattern functionPattern = Pattern.compile("(/item/)([a-z]+)");

    @Inject ItemGetController getController;
    @Inject ItemPostController postController;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        Matcher matcher = pattern.matcher(uri);
        Matcher functionMatcher = functionPattern.matcher(uri);

        boolean match = false;
        String function = null;
        long id = 0;

        if(matcher.find()) {

            match = true;

            if(!matcher.group(4).isEmpty()) {
                function = matcher.group(4);
            }

            id = Long.parseLong(matcher.group(3));

        } else if(functionMatcher.find()) {
            function = functionMatcher.group(2);
            match = true;

        }


        RequestDispatcher view;
        ModelAndView modelView = new ModelAndView();


        if(!match) {
            response.setStatus(404);
            view = request.getRequestDispatcher("/404.jsp");
            view.forward(request, response);

        } else if(function != null) {
            Item item;
            function = function.replace('/', ' ').trim();
            switch (function) {
                case "image" :
                    modelView = getController.retrieveItem(id);
                    item = (Item) modelView.getModel();
                    modelView.setView(item.getImgUrl());

                    break;
                case "new" :
                    modelView.setModel(new Item());
                    modelView.setView("/WEB-INF/newItem.jsp");
                    break;
                case "delete" :
                    modelView = getController.deleteItem(id);
                    break;
                case "update" :
                    modelView = getController.retrieveItem(id);
                    item = (Item) modelView.getModel();
                    modelView.setView("/WEB-INF/newItem.jsp");
                    request.setAttribute("model",item);
                    break;
                default:
                    modelView = new ModelAndView();
                    request.setAttribute("itemId", id);
                    modelView.setView("/404.jsp");
            }

            view = getServletContext().getRequestDispatcher(modelView.getViewName());
            view.forward(request, response);

        } else  {
            modelView = getController.retrieveItem(id);


            Object model = modelView.getModel();
            if(model != null) {
                view = getServletContext().getRequestDispatcher("/WEB-INF/item.jsp");
                request.setAttribute("model", modelView.getModel());
                view.forward(request, response);

            } else {
                response.setStatus(404);
                request.setAttribute("itemId", id);
                view = getServletContext().getRequestDispatcher("/404.jsp");
                view.forward(request, response);

            }

        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Pattern postPattern = Pattern.compile("(/item)(/[a-z]+)");
        Matcher matcher = postPattern.matcher(request.getRequestURL());
        boolean found = false;
        String function = "";
        ModelAndView modelView = new ModelAndView();

        if(matcher.find()) {
            found = true;
            function = matcher.group(2);
            function = function.replace('/', ' ');
            function = function.trim();

        }

        switch (function) {
            case "bid":
                modelView = postController.placeBid(getId(request));
                break;
            case "create":
                modelView = postController.createItem();
                break;
            case "update":
                modelView = postController.updateItem(getId(request));
                break;
            default:
                modelView = new ModelAndView();
                modelView.setView("/404.jsp");


        }

        request.setAttribute("model", modelView.getModel());

        response.sendRedirect(modelView.getViewName());
    }

    private long getId(HttpServletRequest request) {
        long id = 0L;

        try {
            id = Long.parseLong(request.getParameter("id"));

        } catch(NumberFormatException nfe) {
            nfe.printStackTrace();
        }

        return id;
    }

}

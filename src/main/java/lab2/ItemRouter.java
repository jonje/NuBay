package lab2;

import lab2.controller.ItemGetController;
import lab2.model.DataAccessFactory;
import lab2.model.DataAccessLayer;
import lab2.model.Item;
import lab2.modelandview.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jjensen on 4/23/14.
 */
@WebServlet("/item/*")
public class ItemRouter extends HttpServlet {
    private static DataAccessLayer dal = DataAccessFactory.create("hashmap");

    private final Pattern pattern = Pattern.compile("(/item)(/)([0-9]+)([/a-z]*)");
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        Matcher matcher = pattern.matcher(uri);
        ItemGetController getController = new ItemGetController(request, response);
        boolean match = false;
        String function = null;
        long id = 0;

        while(matcher.find()) {

            match = true;

            if(!matcher.group(4).isEmpty()) {
                function = matcher.group(4);
            }

            id = Long.parseLong(matcher.group(3));

        }


        RequestDispatcher view;
        ModelAndView modelView = null;


        if(!match) {
            response.setStatus(404);
            view = request.getRequestDispatcher("/404.html");
            view.forward(request, response);

        } else if(function != null) {

            function = function.replace('/', ' ');
            switch (function) {
                case "image" :
                    //modelView = getController.retrieveItem(id);
                    break;
                case "new" :
                    break;
                case "delete" :
                    break;
                case "update" :
                    break;
                default:


            }

            Item item = (Item) modelView.getModel();
            view = getServletContext().getRequestDispatcher(item.getImgUrl());
            view.forward(request, response);

        } else  {
            modelView = getController.retrieveItem(id);


            Object model = modelView.getModel();
            if(model != null) {
                view = getServletContext().getRequestDispatcher("/item.jsp");
                request.setAttribute("model", modelView.getModel());
                view.forward(request, response);

            } else {
                response.setStatus(404);
                view = getServletContext().getRequestDispatcher("/404.html");
                view.forward(request, response);

            }

        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        if(bid.isEmpty()) {
            bid = "1.00";
        }

        Item item = new Item();
        item.setBid(bid);
        long id = Long.parseLong(request.getParameter("id"));
        item.setId(id);

        dal.update(item);

        response.sendRedirect(request.getContextPath() + "/item/" + item.getId());
    }

}

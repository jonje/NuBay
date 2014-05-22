package lab2.controller;

import lab2.model.ApplicationContext;
import lab2.model.DataAccessLayer;
import lab2.modelandview.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jjensen on 5/7/14.
 */
public class ItemGetController {
    private DataAccessLayer dal;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public ItemGetController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        ApplicationContext context = ApplicationContext.getInstance();
        this.dal = (DataAccessLayer) context.getAttribute("dal");

    }

    public ModelAndView retrieveItem(long id) {
        ModelAndView modelView = new ModelAndView();
        modelView.setModel(dal.getItem(id));
        modelView.setView("item.jsp");
        return modelView;
    }

    public ModelAndView updateItem(long id) {
        return null;
    }

    public ModelAndView createItem() {
        return null;
    }

    public ModelAndView deleteItem() {
        return null;
    }
}

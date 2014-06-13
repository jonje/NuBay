package edu.neumont.jjensen.controller;

import edu.neumont.jjensen.model.ApplicationContext;
import edu.neumont.jjensen.model.DataAccessLayer;
import edu.neumont.jjensen.model.Item;
import edu.neumont.jjensen.modelandview.ModelAndView;
import edu.neumont.jjensen.service.ItemDbService;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jjensen on 5/7/14.
 */
@Stateless
@LocalBean
public class ItemGetController {
    @Inject ItemDbService itemService;
    @Inject HttpServletRequest request;
    @Inject HttpServletResponse response;

    public ModelAndView retrieveItem(long id) {
        ModelAndView modelView = new ModelAndView();
        modelView.setModel(itemService.findById(id));
        modelView.setView("/WEB-INF/item.jsp");
        return modelView;
    }

    public ModelAndView updateItem(long id) {
        return null;
    }

    public ModelAndView createItem() {
        return null;
    }

    public ModelAndView deleteItem(long id) {
        ModelAndView modelView = new ModelAndView();
        modelView.setModel(itemService.findById(id));

//        if() {
//            modelView.setView("/WEB-INF/deleted.jsp");
//        } else {
//            modelView.setView("/item/" + id);
//        }
        return modelView;
    }
}

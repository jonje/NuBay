package edu.neumont.jjensen.controller;

import edu.neumont.jjensen.model.ApplicationContext;
import edu.neumont.jjensen.model.DataAccessLayer;
import edu.neumont.jjensen.model.Item;
import edu.neumont.jjensen.modelandview.ModelAndView;
import org.joda.time.DateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.math.BigDecimal;
import java.util.IllegalFormatException;

/**
 * Created by jjensen on 5/7/14.
 */
public class ItemPostController {
    private HttpServletResponse response;
    private HttpServletRequest request;
    private DataAccessLayer dal;
    private ApplicationContext applicationContext;

    public ItemPostController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.applicationContext = ApplicationContext.getInstance();
        this.dal = (DataAccessLayer) applicationContext.getAttribute("dal");
    }

    public ModelAndView createItem() {
        ModelAndView modelView = new ModelAndView();

        String stringId = request.getParameter("itemId");
        long id;
        Item item;

        if(stringId.isEmpty()) {
            item = new Item();
            item = loadItem(item);
            id = dal.create(item);
            item.setId(id);


        } else {
            id = parseId(stringId);
            item = dal.getItem(id);
            item = loadItem(item);

            if(dal.update(item)) {
                request.setAttribute("status", true);
            } else {
                request.setAttribute("status", false);
            }

        }

        modelView.setModel(item);
        modelView.setView("/item/" + id);

        return modelView;
    }

    public ModelAndView updateItem(long id) {
        return null;
    }

    public ModelAndView placeBid(long id) {
        Item item = dal.getItem(id);
        String bid = request.getParameter("bid");

        if(bid.isEmpty()) {
            bid = "1.00";
            bid = item.getCurrentBid().add(new BigDecimal(bid)).toString();

        }

        if(item.isBidGreaterThanStarting(bid) && item.isBidGreater(bid)) {
            item.setBid(bid);
            request.setAttribute("bidStatus", true);
        } else {
            request.setAttribute("bidStatus", false);

        }

        ModelAndView modelView = new ModelAndView();
        modelView.setModel(item);

        modelView.setView(request.getContextPath() + "/item/" + item.getId());

        return modelView;
    }

    private long parseId(String idString) throws IllegalFormatException {
        long id = 0L;

        if(!idString.isEmpty()) {
            try {
                id = Long.parseLong(idString);

            } catch (IllegalFormatException e) {
                throw e;
            }
        }

        return id;
    }

    private Item loadItem(Item item) {
        String expiration = request.getParameter("expiration");
        item.setExpirationDate(expiration);
        item.setTitle(request.getParameter("title"));
        item.setDescription(request.getParameter("description"));
        if(item.getNumberOfBids() == 0) {
            item.setStartingBid(request.getParameter("startingBid"));
        }
        item.setImgUrl(request.getParameter("imgUrl"));

        return item;
    }
}

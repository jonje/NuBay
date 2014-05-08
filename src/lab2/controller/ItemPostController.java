package lab2.controller;

import lab2.modelandview.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jjensen on 5/7/14.
 */
public class ItemPostController {
    private HttpServletResponse response;
    private HttpServletRequest request;

    public ItemPostController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;

    }

    public ModelAndView createItem() {

        return null;
    }

    public ModelAndView updateItem(String id) {
        return null;
    }

    public ModelAndView placeBid(String id) {
        return null;
    }
}

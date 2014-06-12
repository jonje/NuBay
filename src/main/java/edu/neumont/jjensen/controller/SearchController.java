package edu.neumont.jjensen.controller;

import edu.neumont.jjensen.model.ApplicationContext;
import edu.neumont.jjensen.model.DataAccessLayer;
import edu.neumont.jjensen.model.Item;
import edu.neumont.jjensen.modelandview.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by jjensen on 6/10/14.
 */
public class SearchController {

    private DataAccessLayer dal;
    private HttpServletRequest request;
    private HttpServletResponse response;

    public SearchController(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        ApplicationContext context = ApplicationContext.getInstance();
        this.dal = (DataAccessLayer) context.getAttribute("dal");
    }

    public ModelAndView getResults(List<String> terms) {
        Set<Item> items = dal.getAll();
        List<Item> results = new ArrayList<>();
        ModelAndView modelAndView = new ModelAndView();

        for(Item item : items) {
            for(String term : terms) {
                if(doesMatch(item, term) && (!item.isClosed())) {
                    results.add(item);
                }
            }

        }
        modelAndView.setModel(results);
        modelAndView.setView("/search?page=1");
        return modelAndView;

    }

    private boolean doesMatch(Item item, String searchTerm) {
        String title = item.getTitle().toLowerCase();
        String description = item.getDescription().toLowerCase();
        searchTerm = searchTerm.toLowerCase();
        return title.contains(searchTerm)|| description.contains(searchTerm);
    }

}

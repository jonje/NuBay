package edu.neumont.jjensen.controller;

import edu.neumont.jjensen.model.ApplicationContext;
import edu.neumont.jjensen.model.DataAccessLayer;
import edu.neumont.jjensen.model.Item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
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

    public Set<Item> getResults(String[] terms) {
        Set<Item> items = dal.getAll();
        Set<Item> results = new HashSet<>();

        for(Item item : items) {
            for(String term : terms) {
                if(doesMatch(item, term)) {
                    results.add(item);
                }
            }

        }

        return results;

    }

    private boolean doesMatch(Item item, String searchTerm) {
        return item.getTitle().contains(searchTerm) || item.getDescription().contains(searchTerm) ? true : false;
    }

}

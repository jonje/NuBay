package edu.neumont.jjensen;

import edu.neumont.jjensen.controller.SearchController;
import edu.neumont.jjensen.model.Item;
import edu.neumont.jjensen.modelandview.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Created by jjensen on 6/10/14.
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private final static String[] dictionary = {
            "the", "there", "is", "who", "something", "stuff", "with", "so", "a", "this"
    };

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SearchController searchController = new SearchController(request, response);
        String query = request.getParameter("searchBar");
        List<String> searchTerms = new ArrayList<>(Arrays.asList(query.split(" ")));
        searchTerms = trimSearchTerms(searchTerms);
        ModelAndView modelAndView = searchController.getResults(searchTerms);

        HttpSession session = request.getSession();
        session.setAttribute("itemsList", modelAndView.getModel());

        response.sendRedirect(modelAndView.getViewName());

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        int recordsPerPage = 10;
        if(request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        HttpSession session = request.getSession();
        List<Item> items = (List<Item>) session.getAttribute("itemsList");

        int numberOfRecords = items.size();
        int numberOfPages = (int) Math.ceil(numberOfRecords * 1.0 / recordsPerPage);

        if(items.size() == 0) {
            request.setAttribute("message", "No Results Found");
        }

        request.setAttribute("model", getRecords((page-1), recordsPerPage, items));
        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
        view.forward(request, response);
    }

    private List<String> trimSearchTerms(List<String> searchTerms) {
        for(String word : dictionary) {
            searchTerms.remove(word);
        }

        return searchTerms;
    }

    private List<Item> getRecords(int pageNumber, int recordsPerPage, List<Item> items) {
        int startingIndex = pageNumber * recordsPerPage;
        int endingIndex = startingIndex + recordsPerPage;
        List<Item> itemList = new ArrayList<>();

        for(int i = startingIndex; i < endingIndex && i < items.size(); i++) {
                itemList.add(items.get(i));

        }

        return itemList;
    }
}


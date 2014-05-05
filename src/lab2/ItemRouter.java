package lab2;
import javax.servlet.*;
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

    private final Pattern pattern = Pattern.compile("(/item)(/)([0-9]+)");
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        String results = "";
        Matcher matcher = pattern.matcher(uri);

        boolean match = false;
        while(matcher.find()) {
            results = matcher.group(3);
            match = true;

        }

        if(!match) {
            response.setStatus(404);
            RequestDispatcher view = request.getRequestDispatcher("/404.html");
            view.forward(request, response);
        } else  {
            request.setAttribute("id", results);
            request.setAttribute("dal", dal);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/getItem");
            dispatcher.include(request, response);
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bid = request.getParameter("bid");
        Item item = new Item();
        item.setBid(bid);
        item.setId(request.getParameter("id"));

        dal.update(item);

        response.sendRedirect("/lab2/item/" + item.getId());
    }

}
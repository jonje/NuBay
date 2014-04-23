package lab2;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Created by jjensen on 4/23/14.
 */
@WebServlet("/item")
public class Item  extends HttpServlet {

    private final Pattern pattern = Pattern.compile("(/)([0-9]+)");
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/getItem");
        dispatcher.include(request, response);
    }

}

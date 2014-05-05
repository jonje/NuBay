package lab2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;

/**
 * Created by jjensen on 4/23/14.
 */
@WebServlet("/getItem")
public class GetItem extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataAccessLayer dal = (DataAccessLayer)request.getAttribute("dal");
        Item item = dal.getItem((String)request.getAttribute("id"));
        //JOptionPane.showMessageDialog(null, item.getId(), "Reached Point:", JOptionPane.INFORMATION_MESSAGE);
        request.setAttribute("item", item);

        RequestDispatcher view = request.getRequestDispatcher("/item.jsp");

        view.forward(request, response);

    }
}

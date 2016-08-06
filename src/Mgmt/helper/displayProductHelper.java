package Mgmt.helper;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import Mgmt.games.*;
import Mgmt.gameDB.*;

public class displayProductHelper extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // get request parameters
        String productCode = request.getParameter("productCode");

        // update the Model
       // Product product = ProductDB.selectProduct(productCode);
      //  
       // HttpSession session = request.getSession();
       // session.setAttribute("product", product);

        // forward to the View
        String url = "/games/" + productCode + "/product.jsp";
      //  RequestDispatcher dispatcher =
      //      getServletContext().getRequestDispatcher(url);
      //  dispatcher.forward(request, response);
        response.sendRedirect(url);
    }
}

package Mgmt.helper;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class browseHelper
 */
public class browseHelper extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public browseHelper() {
        super();
        // TODO Auto-generated constructor stub
    }

 /**
  * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request, response);
 }

 /**
  * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
  */
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String a1 = request.getParameter("category");
  String a2 = request.getParameter("login");
    if(a1.equals("newest")){
     response.sendRedirect("games/home.jsp?login="+a2);
    }else if (a1.equals("oldest")){
     response.sendRedirect("games/index1.jsp?login="+a2); 
    }else if (a1.equals("rating1")){
     response.sendRedirect("games/index2.jsp?login="+a2);
    }else if (a1.equals("rating2")){
     response.sendRedirect("games/index3.jsp?login="+a2);
    }else if (a1.equals("pricing1")){
     response.sendRedirect("games/index4.jsp?login="+a2);
    }else{
     response.sendRedirect("games/index5.jsp?login="+a2);
    }
  }

  
 }

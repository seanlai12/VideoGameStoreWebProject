package Mgmt.helper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class browseHelper
 */
public class checkLogin extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkLogin() {
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

  String a1 = request.getParameter("productCode");
  String a2 = request.getParameter("login");
  PrintWriter out = response.getWriter();
  if(a2.equals("") || (a2.equals("null")))
  {
	   out.println("<script type=\"text/javascript\">");
	   out.println("alert('Must be logged in to purchase.');");
	   out.println("location='/Final/games/product.jsp?login=null&productCode="+a1+"'");
	   out.println("</script>");
  }
  else{	  
  response.sendRedirect("store/buyconfirmation.jsp?login="+a2+"&productCode="+a1);
  }
  
 }
}
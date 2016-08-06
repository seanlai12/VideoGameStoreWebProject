package Mgmt.helper;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mgmt.accountDB.AccountDB;

/**
 * Servlet implementation class browseHelper
 */
public class loginHelper extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginHelper() {
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
  String a1 = request.getParameter("username");
  String a2 = request.getParameter("password");
  AccountDB acctdb = new AccountDB();
  if(acctdb.checkLogin(a1, a2))
  {
	  response.sendRedirect("home.jsp?login="+a1);
  }
  else
  {
	  response.sendRedirect("loginError.jsp?login=null");
  }
  
 }
}

package Mgmt.helper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mgmt.accounts.*;
import Mgmt.accountDB.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class accHelper
 */
public class accHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public accHelper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String a1 = request.getParameter("username");
		  String a2 = request.getParameter("password");
		  String a3 = request.getParameter("email");
		  response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		  
		  Account account = new Account(a1, a2, a3);
		  AccountDB db = new AccountDB();
		  
		  if(db!=null)
		  {
			  if(db.checkExists(a1))
			  {
				  out.println("<script type=\"text/javascript\">");
				  out.println("alert('Username already exists!');");
				  out.println("location='/Final/email/register.jsp?login=null'");
				  out.println("</script>");
				  
			  }
			  else
			  {
				  db.registerAccount(account);
				  out.println("<script type=\"text/javascript\">");
				  out.println("alert('Welcome to Super Game Store! You are now logged in!');");
				  out.println("location='/Final/home.jsp?login="+a1+"'");
				  out.println("</script>");
			  }
		  }
		  
	}

}

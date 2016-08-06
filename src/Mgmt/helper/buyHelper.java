package Mgmt.helper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Mgmt.games.*;
import Mgmt.gameDB.*;
import Mgmt.transactionDB.TransactionDB;
import Mgmt.transactions.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class accountHelper
 */
@WebServlet("/buyHelper")
public class buyHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
		@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
		@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a1 = request.getParameter("quantity");
		String a2 = request.getParameter("productCode");
		String foo = request.getParameter("login");
		int dec = Integer.parseInt(a1);
		int prod = Integer.parseInt(a2);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		GameDB db = new GameDB();
		TransactionDB traDB = new TransactionDB();
		Transaction tra = new Transaction(foo, prod, dec, "");
		
		if (!(db.checkStock(a2, dec)))
		{
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Not enough stock left!');");
			   out.println("location='/Final/games/product.jsp?login="+foo+"&productCode="+a2+"'");
			   out.println("</script>");
			
		}
		else{
		if(db!=null)
		{
			db.changeStock(prod, -dec);
		}
		if(traDB!=null)
		{
			traDB.registerTransaction(tra);
		}
		
		response.sendRedirect("store/thankyou.jsp?login="+foo);
		}
}
}



package Mgmt.helper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mgmt.ratingDB.RatingDB;
import Mgmt.ratings.Rating;
import Mgmt.transactionDB.TransactionDB;
import Mgmt.transactions.Transaction;
import Mgmt.gameDB.GameDB;
import Mgmt.games.Game;

import java.sql.*;
import java.util.*;

/**
 * Servlet implementation class ratingHelper
 */
public class revenueHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public revenueHelper() {
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
		String a1 = request.getParameter("login");
		double total = 0;
		
		TransactionDB traDB = new TransactionDB();
		GameDB gamesDB = new GameDB();
		
		ArrayList<Transaction> tra = traDB.selectTransactions();
		for(int i = 0; i < tra.size(); i++){
			total = total + (gamesDB.checkPriceID(tra.get(i).getGameid()) * tra.get(i).getQuantity()); 
		}
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Total revenue from purchases are $"+total+"');");
		out.println("location='/Final/transactionHistory.jsp?login="+a1+"'");
		out.println("</script>");
}

}

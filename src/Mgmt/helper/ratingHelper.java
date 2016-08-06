package Mgmt.helper;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Mgmt.ratingDB.RatingDB;
import Mgmt.ratings.Rating;
import Mgmt.gameDB.GameDB;
import Mgmt.games.Game;
import java.sql.*;
import java.util.*;

/**
 * Servlet implementation class ratingHelper
 */
public class ratingHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ratingHelper() {
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
		String a1 = request.getParameter("rating");
		String a2 = request.getParameter("productCode");
		String a3 = request.getParameter("login");
		String name = a3;
		if(a3.equals("") || a3.equals("null"))
		{
			name = "Anonymous";
		}
		String a4 = request.getParameter("comment");
		int rat = Integer.parseInt(a1);
		int prod = Integer.parseInt(a2);
		response.setContentType("text/html");
		
		RatingDB db = new RatingDB();
		GameDB gamedb = new GameDB();
		Rating newRat = new Rating(prod, name, "", rat, a4);
		if(db!=null)
		{
			db.registerRating(newRat);
		}
		double avg = 1;
		
		avg =  db.getSum(prod);
		avg = avg / db.getCount(prod);
		gamedb.updateRating(a2, avg);
		
		response.sendRedirect("home.jsp?login="+a3);
}

}

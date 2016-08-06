package Mgmt.helper;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
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

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.output.*;

/**
 * Servlet implementation class ratingHelper
 */
public class deleteGameHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteGameHelper() {
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
		String a1 = request.getParameter("delete");
		String a2 = request.getParameter("login");

		
		
	      
		GameDB gamedb = new GameDB();
		
		if(gamedb!=null)
		{
			gamedb.deleteGame(a1);
		}
		
		response.sendRedirect("home.jsp?login="+a2);
}

}

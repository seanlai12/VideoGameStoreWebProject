package Mgmt.ratingDB;

import java.sql.*;
import java.util.*;

import Mgmt.ratings.Rating;
import data.dbConnect.DBConnectionPool;

public class RatingDB {
	//select one rating
	final static String db_url = "jdbc:mysql://localhost:3306/CSS490D";
	final static String db_username = "root";
	final static String db_passwd = "test12";
	
	public DBConnectionPool connPool = null;
	
	public RatingDB(){
		this.connPool = setDBConnection();
	}
	
	public DBConnectionPool setDBConnection(){
		try{
			connPool = new DBConnectionPool(db_url, db_username, db_passwd);
		}catch (Exception et) {
			et.printStackTrace();
		}
		return connPool;
	}
	
	public Rating selectRating(int gameID){
		Statement stmt = null;
		ResultSet rs = null;
		Rating rating = new Rating();
		Connection conn = null;
		try{
			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "select gameID, raterinfo, date, rating, comment from ratings "+
						" where gameID = '"+gameID+"'";
				rs = stmt.executeQuery(strQuery);
				if(rs.next()){
					rating.setGameID(rs.getInt(1));
					rating.setRaterinfo(rs.getString(2));
					rating.setDate(rs.getString(3));
					rating.setRating(rs.getInt(4));
				}
			}
		}catch(SQLException e){
			for(Throwable t: e){	
				t.printStackTrace();
			}
		}catch (Exception et) {
			et.printStackTrace();
		}finally {
		    try {
		    	if (rs != null){
		            rs.close();
		        }
		    	if (stmt != null){
		            stmt.close();
		        }
		        if (conn != null) {
		            connPool.returnConnection(conn);
		        }
		    }catch(Exception e){
		    	 System.err.println(e);
		    }
		}
		return rating;
	}
	
	//insert a new rating
	public double getSum(int gameID){
		Statement stmt = null;
		ResultSet rs = null;
		Rating rating = new Rating();
		Connection conn = null;
		double n = 0;
		try{
			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "SELECT SUM(rating) FROM ratings where gameID = "+gameID;
				rs = stmt.executeQuery(strQuery);
				if(rs.next()){
					n = rs.getInt(1);
				}
			}
		}catch(SQLException e){
			for(Throwable t: e){	
				t.printStackTrace();
			}
		}catch (Exception et) {
			et.printStackTrace();
		}finally {
		    try {
		    	if (rs != null){
		            rs.close();
		        }
		    	if (stmt != null){
		            stmt.close();
		        }
		        if (conn != null) {
		            connPool.returnConnection(conn);
		        }
		    }catch(Exception e){
		    	 System.err.println(e);
		    }
		}
		return n;
	}
	
	public int getCount(int gameID){
		Statement stmt = null;
		ResultSet rs = null;
		Rating rating = new Rating();
		Connection conn = null;
		int n = 0;
		try{
			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "SELECT COUNT(rating) FROM ratings where gameID = "+gameID;
				rs = stmt.executeQuery(strQuery);
				if(rs.next()){
					n = n + rs.getInt(1);
				}
			}
		}catch(SQLException e){
			for(Throwable t: e){	
				t.printStackTrace();
			}
		}catch (Exception et) {
			et.printStackTrace();
		}finally {
		    try {
		    	if (rs != null){
		            rs.close();
		        }
		    	if (stmt != null){
		            stmt.close();
		        }
		        if (conn != null) {
		            connPool.returnConnection(conn);
		        }
		    }catch(Exception e){
		    	 System.err.println(e);
		    }
		}
		return n;
	}
	
	public int registerRating(Rating rating){
		Statement stmt = null;
		ResultSet rs = null;
		int resultNo = 0;
		Connection conn = null;
		try{
			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "insert ratings(gameID, raterinfo, date, rating, comment) values('"+
						rating.getGameID()+"', '"+rating.getRaterinfo()+"', now(), '"+rating.getRating()+"', '"+rating.getComment()+"')";
				resultNo = stmt.executeUpdate(strQuery);
			}
		}catch(SQLException e){
			for(Throwable t: e){	
				t.printStackTrace();
			}
		}catch(Exception et) {
			et.printStackTrace();
		}finally {
		    try {
		    	if (rs != null){
		            rs.close();
		        }
		    	if (stmt != null){
		            stmt.close();
		        }
		        if (conn != null) {
		            connPool.returnConnection(conn);
		        }
		    }catch(Exception e){
		    	 System.err.println(e);
		    }
		}
		return resultNo;
	}
	
	//update one rating's information
	
	public int updateRating(Rating rating){
		Statement stmt = null;
		ResultSet rs = null;
		int resultNo = 0;
		Connection conn = null;
		try{

			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "update rating set gameID= '"+rating.getGameID()+"',"
						+ " raterinfo = "+rating.getRaterinfo()+"', date = '"+rating.getDate()+"', rating = "
						+rating.getRating()+ ", comment = +rating.getComment() "+
				"' where gameID = '"+rating.getGameID()+"'"; 
				resultNo = stmt.executeUpdate(strQuery);
			}
		}catch(SQLException e){
			for(Throwable t: e){	
				t.printStackTrace();
			}
		} catch (Exception et) {
			et.printStackTrace();
		}finally {
		    try {
		    	if (rs != null){
		            rs.close();
		        }
		    	if (stmt != null){
		            stmt.close();
		        }
		        if (conn != null) {
		            connPool.returnConnection(conn);
		        }
		    }catch(Exception e){
		    	 System.err.println(e);
		    }
		}
		return resultNo;
	}
	
	//delete one rating
	
	public int deleteRating(int gameID){
		Statement stmt = null;
		ResultSet rs = null;
		int resultNo = 0;
		Connection conn = null;
		try{

			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "delete from ratings where gameID = '"+gameID+"'";
				resultNo = stmt.executeUpdate(strQuery);
			}
		}catch(SQLException e){
			for(Throwable t: e){	
				t.printStackTrace();
			}
		} catch (Exception et) {
			et.printStackTrace();
		}finally {
		    try {
		    	if (rs != null){
		            rs.close();
		        }
		    	if (stmt != null){
		            stmt.close();
		        }
		        if (conn != null) {
		            connPool.returnConnection(conn);
		        }
		    } catch(Exception e){
		    	 System.err.println(e);
		    }
		}
		return resultNo;
	}
	
	//select multiple ratings 
	
	public ArrayList<Rating> selectRatings(){
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		ArrayList<Rating> ratings = new ArrayList<>();
		try{

			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "select gameID, raterinfo, date, rating, comment from ratings";
				rs = stmt.executeQuery(strQuery);
				while(rs.next()){
					Rating rat = new Rating();
					rat.setGameID(rs.getInt(1));
					rat.setRaterinfo(rs.getString(2));
					rat.setDate(rs.getString(3));
					rat.setRating(rs.getInt(4));
					ratings.add(rat);
				}
			}
		}catch(SQLException e){
			for(Throwable t: e){	
				t.printStackTrace();
			}
		} catch (Exception et) {
			et.printStackTrace();
		}finally {
		    try {
		    	if (rs != null){
		            rs.close();
		        }
		    	if (stmt != null){
		            stmt.close();
		        }
		        if (conn != null) {
		            connPool.returnConnection(conn);
		        }
		    }catch(Exception e){
		    	 System.err.println(e);
		    }
		}
		return ratings;
	}


public ArrayList<Rating> selectRatingsOnID(int id){
	Statement stmt = null;
	ResultSet rs = null;
	Connection conn = null;
	ArrayList<Rating> ratings = new ArrayList<>();
	try{

		conn = connPool.getConnection();
		
		if(conn != null){
			stmt = conn.createStatement();
			
			String strQuery = "select rating from ratings where gameid = "+id;
			rs = stmt.executeQuery(strQuery);
			while(rs.next()){
				Rating rat = new Rating();
				rat.setRating(rs.getInt(1));
				rat.setRaterinfo("");
				rat.setDate(rs.getString(""));
				rat.setRating(rs.getInt(0));
				ratings.add(rat);
			}
		}
	}catch(SQLException e){
		for(Throwable t: e){	
			t.printStackTrace();
		}
	} catch (Exception et) {
		et.printStackTrace();
	}finally {
	    try {
	    	if (rs != null){
	            rs.close();
	        }
	    	if (stmt != null){
	            stmt.close();
	        }
	        if (conn != null) {
	            connPool.returnConnection(conn);
	        }
	    }catch(Exception e){
	    	 System.err.println(e);
	    }
	}
	return ratings;
}
}


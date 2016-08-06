package Mgmt.gameDB;

import java.sql.*;
import java.util.*;

import Mgmt.games.Game;
import data.dbConnect.DBConnectionPool;

public class GameDB {
	//select one game
	final static String db_url = "jdbc:mysql://localhost:3306/CSS490D";
	final static String db_username = "root";
	final static String db_passwd = "test12";
	
	public DBConnectionPool connPool = null;
	
	public GameDB(){
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
	
	public Game selectGame(String name){
		Statement stmt = null;
		ResultSet rs = null;
		Game game = new Game();
		Connection conn = null;
		try{
			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "select id, name, rating, stock, price, info, genre from games "+
						" where name = '"+name+"'";
				rs = stmt.executeQuery(strQuery);
				if(rs.next()){
					game.setID(rs.getInt(1));
					game.setName(rs.getString(2));
					game.setRating(rs.getInt(3));
					game.setStock(rs.getInt(4));
					game.setPrice(rs.getInt(5));
					game.setInfo(rs.getString(6));
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
		return game;
	}
	
	//insert a new game
	
	public int registerGame(Game game){
		Statement stmt = null;
		ResultSet rs = null;
		int resultNo = 0;
		Connection conn = null;
		try{
			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "insert games(name, rating, stock, price, info, genre, image) values('"+
						game.getName()+"', '"+game.getRating()+"', '"+game.getStock()+"', '"+game.getPrice()+"', '"+game.getInfo()+"', '"+game.getGenre()+"', '"+game.getImage()+"')";
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
	
	//update one game's information
	
	public int updateGame(Game game){
		Statement stmt = null;
		ResultSet rs = null;
		int resultNo = 0;
		Connection conn = null;
		try{

			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "update game set name= '"+game.getName()+"', rating = '"+game.getRating()+"', stock = '"+game.getStock()+
				"', price = '"+game.getPrice()+"', info = '"+game.getInfo()+"', genre = '"+game.getGenre()+"', image = '"+game.getImage()+
						"' where name = '"+game.getName()+"'"; 
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
	
	public int updateRating(String gameID, double rating){
		Statement stmt = null;
		ResultSet rs = null;
		int resultNo = 0;
		double n = Math.round(rating*100)/100.0d;;
		Connection conn = null;
		try{

			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "update games set rating = "+n+" where id = "+gameID;
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
	
	public boolean checkStock(String gameID, int n){
		Statement stmt = null;
		ResultSet rs = null;
		int resultNo = 0;
		Connection conn = null;
		boolean bo = false;
		try{

			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "select stock from games "+
						" where id = '"+gameID+"'";
				rs = stmt.executeQuery(strQuery);
				
				while(rs.next())
				{
					bo = rs.getInt(1) > n;
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
		return bo;
	}
	
	public double checkPriceID(int id){
		Statement stmt = null;
		ResultSet rs = null;
		int resultNo = 0;
		Connection conn = null;
		double n = 0;
		try{

			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "select price from games "+
						" where id = '"+id+"'";
				rs = stmt.executeQuery(strQuery);
				
				while(rs.next())
				{
					n = rs.getDouble(1);
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
		return n;
	}
	
	public int changeStock(int id, int n){
		Statement stmt = null;
		ResultSet rs = null;
		int resultNo = 0;
		Connection conn = null;
		try{

			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "UPDATE games set stock = stock + "+n+" where id = "+id+" and stock > 0";
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
	
	//delete one game
	
	public int deleteGame(String name){
		Statement stmt = null;
		ResultSet rs = null;
		int resultNo = 0;
		Connection conn = null;
		try{

			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "delete from games where name = '"+name+"'";
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
	
	//select multiple games 
	
	public ArrayList<Game> selectGames(){
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		ArrayList<Game> games = new ArrayList<>();
		try{

			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "select id, name, rating, stock, price, info, genre, image from games";
				rs = stmt.executeQuery(strQuery);
				while(rs.next()){
					Game gm = new Game();
					gm.setID(rs.getInt(1));
					gm.setName(rs.getString(2));
					gm.setRating(rs.getInt(3));
					gm.setStock(rs.getInt(4));
					gm.setPrice(rs.getInt(5));
					gm.setInfo(rs.getString(6));
					gm.setGenre(rs.getString(7));
					gm.setImage(rs.getString(8));
					games.add(gm);
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
		return games;
	}
}

package Mgmt.transactionDB;

import java.sql.*;
import java.util.*;

import Mgmt.transactions.Transaction;
import data.dbConnect.DBConnectionPool;

public class TransactionDB {
	//select one transaction
	final static String db_url = "jdbc:mysql://localhost:3306/CSS490D";
	final static String db_username = "root";
	final static String db_passwd = "test12";
	
	DBConnectionPool connPool = null;
	
	public TransactionDB(){
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
	
	public Transaction selectTransaction(String name){
		Statement stmt = null;
		ResultSet rs = null;
		Transaction transaction = new Transaction();
		Connection conn = null;
		try{
			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "select name, gameid, quantity, date from transactions "+
						" where name = '"+name+"'";
				rs = stmt.executeQuery(strQuery);
				if(rs.next()){
					transaction.setName(rs.getString(1));
					transaction.setGameid(rs.getInt(2));
					transaction.setQuantity(rs.getInt(3));
					transaction.setDate(rs.getString(1));
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
		return transaction;
	}
	
	//insert a new transaction
	
	public int registerTransaction(Transaction transaction){
		Statement stmt = null;
		ResultSet rs = null;
		int resultNo = 0;
		Connection conn = null;
		try{
			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "insert transactions(name, gameid, quantity, date) values('"+
						transaction.getName()+"', '"+transaction.getGameid()+"', '"+transaction.getQuantity()+"', now())";
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
	
	//update one transaction's information
	
	public int updateTransaction(Transaction transaction){
		Statement stmt = null;
		ResultSet rs = null;
		int resultNo = 0;
		Connection conn = null;
		try{

			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "update transaction set name= '"+transaction.getName()+"', gameid = "
				+transaction.getGameid()+"', quantity = '"+transaction.getQuantity()+"', date = "
						+transaction.getDate()+
				"' where name = '"+transaction.getName()+"'"; 
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
	
	//delete one transaction
	
	public int deleteTransaction(int id){
		Statement stmt = null;
		ResultSet rs = null;
		int resultNo = 0;
		Connection conn = null;
		try{

			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "delete from transactions where id = '"+id+"'";
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
	
	//select multiple transactions 
	
	public ArrayList<Transaction> selectTransactions(){
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		ArrayList<Transaction> transactions = new ArrayList<>();
		try{

			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "select name, gameid, quantity, date from transactions";
				rs = stmt.executeQuery(strQuery);
				while(rs.next()){
					Transaction tra = new Transaction();
					tra.setName(rs.getString(1));
					tra.setGameid(rs.getInt(2));
					tra.setQuantity(rs.getInt(3));
					tra.setDate(rs.getString(1));
					transactions.add(tra);
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
		return transactions;
	}
}

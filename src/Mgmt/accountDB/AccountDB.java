package Mgmt.accountDB;

import java.sql.*;
import java.util.*;

import Mgmt.accounts.Account;
import data.dbConnect.DBConnectionPool;

public class AccountDB {
	//select one account
	final static String db_url = "jdbc:mysql://localhost:3306/CSS490D";
	final static String db_username = "root";
	final static String db_passwd = "test12";
	
	public DBConnectionPool connPool = null;
	
	public AccountDB(){
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
	
	public Account selectAccount(String username){
		Statement stmt = null;
		ResultSet rs = null;
		Account account = new Account();
		Connection conn = null;
		
		try{
			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "select username, password from accounts "+
						" where username = '"+username+"'";
				rs = stmt.executeQuery(strQuery);
				if(rs.next()){
					account.setUsername(rs.getString(1));
					account.setEmail(rs.getString(2));
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
		return account;
	}
	
	public boolean checkLogin(String username, String password){
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		boolean login = false;
		try{
			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "select username, password from accounts where username = '"+username+"'";
				rs = stmt.executeQuery(strQuery);
				while(rs.next()){
					if(rs.getString(1).equals(username) && rs.getString(2).equals(password))
					{
						login = true;
					}
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
		return login;
	}
	
	public boolean checkExists(String username){
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		boolean exist = false;
		try{
			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "select username from accounts where username = '"+username+"'";
				rs = stmt.executeQuery(strQuery);
				while(rs.next()){
					if(rs.getString(1).equals(username))
					{
						exist = true;
					}
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
		return exist;
	}
	//insert a new account
	
	public int registerAccount(Account account){
		Statement stmt = null;
		ResultSet rs = null;
		int resultNo = 0;
		Connection conn = null;
		try{
			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "insert accounts(username, password, email) values('"+
						account.getUsername()+"', '"+account.getPassword()+"', '"+account.getEmail()+
						"')";
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
	
	//update one account's information
	
	public int updateAccount(Account account){
		Statement stmt = null;
		ResultSet rs = null;
		int resultNo = 0;
		Connection conn = null;
		try{

			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "update accounts set email = '"+account.getEmail()+
						"' where username = '"+account.getUsername()+"'"; 
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
	
	//delete one account
	
	public int deleteAccount(String username){
		Statement stmt = null;
		ResultSet rs = null;
		int resultNo = 0;
		Connection conn = null;
		try{

			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "delete from accounts where username = '"+username+"'";
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
	
	//select multiple accounts 
	
	public ArrayList<Account> selectAccounts(){
		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = null;
		ArrayList<Account> accounts = new ArrayList<>();
		try{

			conn = connPool.getConnection();
			
			if(conn != null){
				stmt = conn.createStatement();
				
				String strQuery = "select username, password, email from accounts";
				rs = stmt.executeQuery(strQuery);
				while(rs.next()){
					Account acc = new Account();
					acc.setUsername(rs.getString(1));
					acc.setEmail(rs.getString(2));
					accounts.add(acc);
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
		return accounts;
	}
}

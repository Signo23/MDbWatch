package mdbwatch.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlQuery {

	private SqlQuery() {
	}

	public static void createDB() throws SQLException {
		DBConnection dataSource = new DBConnection();
		Connection connection = dataSource.getMySQLConnection();
	    Statement statement = null;
	    if(!isDBExsisting(connection)) {
	    	 try {
	 	        statement = connection.createStatement ();
	 	        for(String s : SqlInitQuery.VALUES) {
	 	        	statement.executeUpdate(s);
	 	        }
	 	        statement.close ();

	 	    }
	 	    catch (SQLException e) {
	 	    	 
	 	    }
	 	    finally {
	 	        try {
	 	            if (statement != null) 
	 	                statement.close();
	 	            if (connection!= null)
	 	                connection.close();
	 	        }
	 	        catch (SQLException e) {
	 	        }
	 	    }
	    }
	}
	
	private static boolean isDBExsisting(Connection connection) throws SQLException {
		PreparedStatement stm = null;
		String query = "select * from PERSONE";
		stm = connection.prepareStatement(query);
		return stm.execute();
	}
	
	public static boolean verifyUser(String username, String password) {
		return true;
	}

	public static void addUser(String username, String password) {
	}
	
	public static boolean isUserAlreayExsist(String username) {
		return false;
	}
}

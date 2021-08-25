package mdbwatch.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLAdd {

	public static void addUser(String username, String password) {
		 Connection connection = DBConnection.getConnection();
	     PreparedStatement statement = null; 
	     String insert = "insert into utenti\n"
	     		+ "(username, pass_word) values (?,?);";
	     try {
	    	 statement = connection.prepareStatement(insert);
	    	 statement.setString(1, username);
	    	 statement.setString(2,  password);
	    	 statement.executeUpdate();
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
	
	
	public static void addVote(String username, int idProduct, int vote) {
		 Connection connection = DBConnection.getConnection();
	     PreparedStatement statement = null; 
	     String insert = "insert into valutazioni"
	     		+ "(idProdotto, Username, voto) values (?,?,?);";
	     try {
	    	 statement = connection.prepareStatement(insert);
	    	 statement.setInt(1, idProduct);
	    	 statement.setString(2,  username);
	    	 statement.setInt(3, vote);
	    	 statement.executeUpdate();
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
	
	public static void addOnWatchlist (String username, int idProduct) {
		 Connection connection = DBConnection.getConnection();
	     PreparedStatement statement = null; 
	     String insert = "insert into watchlist"
	     		+ "(idProdotto, Username) values (?,?);";
	     try {
	    	 statement = connection.prepareStatement(insert);
	    	 statement.setInt(1, idProduct);
	    	 statement.setString(2,  username);
	    	 statement.executeUpdate();
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
	
	public static void addUserStreamingService(String username, String streaming) {
		Connection connection = DBConnection.getConnection();
	     PreparedStatement statement = null; 
	     String insert = "insert into scelte" +
	    		 "(username, NomeServizio) values (? , ? )";
	     try {
	    	 statement = connection.prepareStatement(insert);
	    	 statement.setString(1, username);
	    	 statement.setString(2,  streaming);
	    	 statement.executeUpdate();
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

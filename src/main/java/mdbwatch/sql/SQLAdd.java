package mdbwatch.sql;
/**
 /* Contain all methods that add add something on DB.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLAdd {

	/**
	 * Add a user in DB
	 * @param username to add
	 * @param password to add
	 */
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

	/**
	 * Add a vote
	 * @param username of the voter
	 * @param idProduct of the product voted
	 * @param vote to add
	 */
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

	/**
	 * Add a product in user's watchlist.
	 * @param username owner of wathclist
	 * @param idProduct to add in the watchlist
	 */
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

	/**
	 * Add a streaming service in the user's choices.
	 * @param username user
	 * @param streaming service to add
	 */
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

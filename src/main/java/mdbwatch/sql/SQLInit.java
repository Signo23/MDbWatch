package mdbwatch.sql;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SQLInit {
	
	private static String[] getQueryInit() {
		FileReader fl;
		try {
			File generator = new File(ClassLoader.getSystemResource("files//sqlGenerator.txt").toURI());
			fl = new FileReader(generator);
			Scanner ln = new Scanner(fl);
			String str = "";
			while(ln.hasNext()) {
				str = String.join("", str, ln.nextLine());
			}
			ln.close();
			String [] parts = str.split(";");
			return parts;
			
			
		} catch (FileNotFoundException e) {
		} catch (URISyntaxException e) {
		}
	return null;
	}
	
	public static void createDB() throws SQLException {
		Connection connection = DBConnection.getConnection();
	    Statement statement = null;
	    if(!isDBExsisting(connection)) {
	    	 try {
	 	        statement = connection.createStatement ();
	 	        for(String s : SQLInit.getQueryInit()) {
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
	
	private static boolean isDBExsisting(Connection connection) {
		PreparedStatement stm = null;
		String query = "select * from PERSONE";
		try {
			stm = connection.prepareStatement(query);
			return stm.execute();
		} catch (SQLException e) {
		}
		return false;
	}
}

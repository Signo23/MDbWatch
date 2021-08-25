package mdbwatch.sql;
/**
 * Conncet to DB.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String DB_NAME = "mdbwatch";

	/**
	 * Connect to the DB.
	 * @return connection to DB
	 */
	public static Connection getConnection()  {
    	//MySQL locale
    	
       String driver = "com.mysql.jdbc.Driver";
       String dbUri = "jdbc:mysql://localhost:3306/" + DB_NAME +"?characterEncoding=latin1&serverTimezone=Europe/Rome";
   	   String userName = "root";
   	   String password = "141000";
        
       Connection connection = null;
        try {
            System.out.println("DataSource.getConnection() driver = "+driver);
            Class.forName(driver);
            System.out.println("DataSource.getConnection() dbUri = "+dbUri);
            connection = DriverManager.getConnection(dbUri, userName, password);
        }
        catch (ClassNotFoundException e) {
            new Exception(e.getMessage());
            System.out.println("Errore: "+ e.getMessage());
        }
        catch(SQLException e) {
            new Exception(e.getMessage());
            System.out.println("Errore"+ e.getMessage());
        }
        return connection;
    }
}

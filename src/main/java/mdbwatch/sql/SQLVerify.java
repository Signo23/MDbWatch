package mdbwatch.sql;
/**
 * Contain all methods that verify something in DB.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLVerify {

	private SQLVerify() {
	}

	/**
	 * Verify if user exist and password is correct.
	 * @param username user to control
	 * @param password password to control
	 * @return {@link true} if is all correct, {@link false} if user or password are incorrect 
	 */
	public static boolean verifyUser(String username, String password) {
		Connection connection = DBConnection.getConnection();
		PreparedStatement stm = null;
		String query = "select * from utenti u where u.Username = ? and u.Pass_word = ?";
		ResultSet result = null;
		boolean exsist = false;
		
		try {
            stm = connection.prepareStatement(query);
            stm.setString(1, username);
            stm.setString(2, password);
            result = stm.executeQuery();
            exsist = result.next();
        }
        catch (SQLException e) {
        }
        finally {
            try {
                if (stm != null) 
                    stm.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
            }
        }
		return exsist;
	}

	/**
	 * Control id a username exsist in DB.
	 * @param username to control
	 * @return {@link true} if username already exist in DB, {@link false} if username doesn't exist in DB
	 */
 	public static boolean isUserAlreayExsist(String username) {
		Connection connection = DBConnection.getConnection();
		PreparedStatement stm = null;
		String query = "select * from utenti u where u.Username = ?";
		ResultSet result = null;
		boolean exsist = false;
		
		try {
            stm = connection.prepareStatement(query);
            stm.setString(1, username);
            result = stm.executeQuery();
            exsist = result.next();
        }
        catch (SQLException e) {
        }
        finally {
            try {
                if (stm != null) 
                    stm.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
            }
        }
		return exsist;
	}

 	/**
 	 * Control if user had already voted a product.
 	 * @param username of user
 	 * @param idProduct of product
 	 * @return {@link true} if user had voted, {@link false} if user had not voted
 	 */
	public static boolean isVoteExsisting(String username, int idProduct) {
		Connection connection = DBConnection.getConnection();
		PreparedStatement stm = null;
		String query = "select * from valutazioni v where v.Username = ? and v.idProdotto = ?";
		ResultSet result = null;
		boolean exsist = false;
		
		try {
            stm = connection.prepareStatement(query);
            stm.setString(1, username);
            stm.setInt(2, idProduct);
            result = stm.executeQuery();
            exsist = result.next();
        }
        catch (SQLException e) {
        }
        finally {
            try {
                if (stm != null) 
                    stm.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
            }
        }
		return exsist;
	}

	/**
	 * Control if a product is in user's watchlist
	 * @param username of user
	 * @param idProduct of product
	 * @return {@link true} if product is in watchlist, {@link false} if product isn't in watchlist
	 */
	public static boolean isInWatchlistProduct(String username, int idProduct) {
		Connection connection = DBConnection.getConnection();
		PreparedStatement stm = null;
		String query = "select * from watchlist where watchlist.Username = ? and watchlist.idProdotto = ?";
		ResultSet result = null;
		boolean exsist = false;
		
		try {
            stm = connection.prepareStatement(query);
            stm.setString(1, username);
            stm.setInt(2, idProduct);
            result = stm.executeQuery();
            exsist = result.next();
        }
        catch (SQLException e) {
        }
        finally {
            try {
                if (stm != null) 
                    stm.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
            }
        }
		return exsist;
	}
}


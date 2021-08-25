package mdbwatch.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLVerify {

	private SQLVerify() {
	}

	
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


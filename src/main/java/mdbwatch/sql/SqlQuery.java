package mdbwatch.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mdbwatch.model.ProductInfo;
import mdbwatch.model.SerieTv;
import mdbwatch.model.SingleProduct;
import mdbwatch.model.MusicInfo;
import mdbwatch.model.Product;

public class SqlQuery {

	private SqlQuery() {
	}

	public static void createDB() throws SQLException {
		Connection connection = getConnection();
	    Statement statement = null;
	    if(!isDBExsisting(connection)) {
	    	 try {
	 	        statement = connection.createStatement ();
	 	        for(String s : SqlInitQuery.getQueryInit()) {
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
			e.printStackTrace();
		}
		return false;
	}
	
	private static Connection getConnection() {
		DBConnection dataSource = new DBConnection();
		return dataSource.getMySQLConnection();
	}
	
	public static boolean verifyUser(String username, String password) {
		Connection connection = getConnection();
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
        	new Exception(e.getMessage());
        }
        finally {
            try {
                if (stm != null) 
                    stm.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
            	new Exception(e.getMessage());
            }
        }
		return exsist;
	}

	public static void addUser(String username, String password) {
		 Connection connection = getConnection();
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
	    	 new Exception(e.getMessage());
	    	 }
	     finally {
	    	 try {
	    		 if (statement != null) 
	    			 statement.close();
	    		 if (connection!= null)
	    			 connection.close();
	    		 }
	    	 catch (SQLException e) {
	    		 new Exception(e.getMessage());
	    		 }
	    	 }
	}
	
	public static boolean isUserAlreayExsist(String username) {
		Connection connection = getConnection();
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
        	new Exception(e.getMessage());
        }
        finally {
            try {
                if (stm != null) 
                    stm.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
            	new Exception(e.getMessage());
            }
        }
		return exsist;
	}
	
	public static void addVote(String username, int idProduct) {
	}
	
	public static void addOnWatchlistProduct(String username, int idProduct) {
		
	}
	
	public static int averageProduct(int idProduct) {
		return 0;
	}
	
	public static ProductInfo getProductInformation(int idProduct){
		return new ProductInfo();
	}
	
	public static List<Product> searchProductByTitle(String title){
		 List<Product> products = new ArrayList<>();
	        
	        Connection connection = getConnection();
	        PreparedStatement statement = null;
	        String query = "select p.* from prodotti_singoli p where p.Titolo like ?;";
	        try {
	            statement = connection.prepareStatement(query);
	            statement.setString(1, "%" + title+ "%");
	            ResultSet result = statement.executeQuery();
	            while (result.next()) {
	                SingleProduct sp = new SingleProduct();
	                sp.setIdProduct(result.getInt("idProdotto"));
	                sp.setTitle(result.getString("Titolo"));
	                sp.setPlot(result.getString("Trama"));
	                sp.setYear(result.getInt("Anno"));
	                sp.setIdDirector(result.getInt("idPersona"));
	                sp.setProduction(result.getString("Produzione"));
	                sp.setIdSerie(result.getInt("idSerie"));
	                sp.setSeason(result.getInt("stagione"));
	                sp.setSeason(result.getInt("numeroEpisodio"));
	                products.add(sp);
	                }
	            products.addAll(searchSerieByTitle(title));
	        }
	        catch (SQLException e) {
	        	new Exception(e.getMessage());
	            System.out.println("Errore"+ e.getMessage());
	        }
	        finally {
	            try {
	                if (statement != null) 
	                    statement.close();
	                if (connection!= null)
	                    connection.close();
	            } catch (SQLException e) {
	            	new Exception(e.getMessage());
		             System.out.println("Errore"+ e.getMessage());
	            }
	        }
		return products;
	}
	
	private static List<Product> searchSerieByTitle(String title){
		 List<Product> products = new ArrayList<>();
	        
	        Connection connection = getConnection();
	        PreparedStatement statement = null;
	        String query = "select s.* from serie_tv p where s.Titolo like '%?%';";
	        try {
	            statement = connection.prepareStatement(query);
	            statement.setString(1, title);
	            ResultSet result = statement.executeQuery();
	            while (result.next()) {
	                SerieTv sp = new SerieTv();
	                sp.setIdProduct(result.getInt("idProdotto"));
	                sp.setTitle(result.getString("Titolo"));
	                sp.setPlot(result.getString("Trama"));
	                products.add(sp);
	                
	                }
	        }
	        catch (SQLException e) {
	        	new Exception(e.getMessage());
	            System.out.println("Errore"+ e.getMessage());
	        }
	        finally {
	            try {
	                if (statement != null) 
	                    statement.close();
	                if (connection!= null)
	                    connection.close();
	            } catch (SQLException e) {
	            	new Exception(e.getMessage());
		             System.out.println("Errore"+ e.getMessage());
	            }
	        }
		return products;
	}
	
	public static List<Product> getProductForUserService(String username){
		return new ArrayList<>();
	}
	
	public static List<Product> getWatchlist(String username) {
		return new ArrayList<>();
	}
	
	public static MusicInfo getMusicInformation(int idMusic) {
		return new MusicInfo();
	}
	
	public List<Product> getProductForProduction (String Production) {
		return new ArrayList<>();
	}
	
	public List<Product> getEpisodies (int idSerie) {
		return new ArrayList<>();
	}
	
	public List<ProductInfo> getSerieInformation (int idSerie) {
		return new ArrayList<>();
	}
}

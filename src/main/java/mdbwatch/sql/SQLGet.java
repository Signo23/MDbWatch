package mdbwatch.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mdbwatch.model.Music;
import mdbwatch.model.Person;
import mdbwatch.model.Product;
import mdbwatch.model.StreamingService;

public class SQLGet {

	public static long getAverageProduct(int idProduct) {
		long avg = 0;
        
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        String query = "select avg(valutazioni.voto) as media\n"
        		+ "from valutazioni\n"
        		+ "where valutazioni.idProdotto = ?;";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, idProduct);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                avg = result.getLong("media");

                }
        }
        catch (SQLException e) {
        }
        finally {
            try {
                if (statement != null) 
                    statement.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
            }
        }
	return avg;
	}
	
	
	public static List<Product> getProductByUserService(String username){
		List<Product> products = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        String query = "select prodotti.*\n"
        		+ "from prodotti, scelte, disponibilitaprodotti\n"
        		+ "where prodotti.idProdotto = disponibilitaprodotti.idProdotto\n"
        		+ "and disponibilitaprodotti.NomeServizio = scelte.NomeServizio\n"
        		+ "and scelte.Username = ?";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
            	Product sp = new Product();
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
        }
        catch (SQLException e) {
        }
        finally {
            try {
                if (statement != null) 
                    statement.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
            }
        }
		return products;
	}


	public static List<Product> getWatchlist(String username) {
		List<Product> products = new ArrayList<>();
        
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        String query = "select prodotti.* "
        		+ "from prodotti, watchlist "
        		+ "where prodotti.idProdotto = watchlist.idProdotto "
        		+ "and watchlist.Username = ? ";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Product sp = new Product();
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
        }
        catch (SQLException e) {

        }
        finally {
            try {
                if (statement != null) 
                    statement.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
            	
            }
        }
	return products;
	}


	public static List<Product> getProductForProduction (String production) {
		List<Product> products = new ArrayList<>();
        
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        String query = "select prodotti.*\n"
        		+ "from prodotti\n"
        		+ "where prodotti.idSerie is null\n"
        		+ "and prodotti.Produzione = ?\n";
        try {
            statement = connection.prepareStatement(query);
            statement.setString(1, production);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Product sp = new Product();
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
        }
        catch (SQLException e) {
    
        }
        finally {
            try {
                if (statement != null) 
                    statement.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
            	
            }
        }
	return products;
	}
	
	public static List<Product> getEpisodies (int idSerie) {
List<Product> products = new ArrayList<>();
        
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        String query = "select prodotti.* "
        		+ "from prodotti "
        		+ "where prodotti.idSerie = ? "
        		+ "order by prodotti.stagione, prodotti.numeroEpisodio ";
        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, idSerie);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Product sp = new Product();
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
        }
        catch (SQLException e) {
        	
        }
        finally {
            try {
                if (statement != null) 
                    statement.close();
                if (connection!= null)
                    connection.close();
            } catch (SQLException e) {
            	
            }
        }
	return products;
	}
	
	
	public static Product getProductById(int id) {
		 Product sp = null;
	        
	        Connection connection = DBConnection.getConnection();
	        PreparedStatement statement = null;
	        String query = "select p.* from prodotti p where p.idProdotto = ?;";
	        try {
	            statement = connection.prepareStatement(query);
	            statement.setInt(1, id);
	            ResultSet result = statement.executeQuery();
	            if (result.next()) {
	                sp = new Product();
	                sp.setIdProduct(result.getInt("idProdotto"));
	                sp.setTitle(result.getString("Titolo"));
	                sp.setPlot(result.getString("Trama"));
	                sp.setYear(result.getInt("Anno"));
	                sp.setIdDirector(result.getInt("idPersona"));
	                sp.setProduction(result.getString("Produzione"));
	                sp.setIdSerie(result.getInt("idSerie"));
	                sp.setSeason(result.getInt("stagione"));
	                sp.setNumber(result.getInt("numeroEpisodio"));
	                }
	        }
	        catch (SQLException e) {
	        	
	        }
	        finally {
	            try {
	                if (statement != null) 
	                    statement.close();
	                if (connection!= null)
	                    connection.close();
	            } catch (SQLException e) {
	            	
	            }
	        }
		return sp;
	}

	public static List<Product> getProductByTitle(String title){
		 List<Product> products = new ArrayList<>();
	        
	        Connection connection = DBConnection.getConnection();
	        PreparedStatement statement = null;
	        String query = "select p.* from prodotti p where p.Titolo like ?;";
	        try {
	            statement = connection.prepareStatement(query);
	            statement.setString(1, "%" + title+ "%");
	            ResultSet result = statement.executeQuery();
	            while (result.next()) {
	                Product sp = new Product();
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
	        }
	        catch (SQLException e) {
	        	
	        }
	        finally {
	            try {
	                if (statement != null) 
	                    statement.close();
	                if (connection!= null)
	                    connection.close();
	            } catch (SQLException e) {
	            	
	            }
	        }
		return products;
	}
	
	public static Person getPersonById(int idPerson) {
		Person person = null;
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		String query = "select * from persone where persone.idPersona = ?;";
       
		try {
       	   statement = connection.prepareStatement(query);
       	   statement.setInt(1, idPerson);
              ResultSet result = statement.executeQuery();
              if(result.next()) {
           	      person = new Person();
           	      person.setId(result.getInt("idPersona"));
           	      person.setName(result.getString("Nome"));
           	      person.setSurname(result.getString("Cognome"));
           	      person.setBirthDay(result.getDate("DataDiNascita"));
              }
		}
		catch (SQLException e) {
			
		}
       finally {
           try {
               if (statement != null) 
                   statement.close();
               if (connection!= null)
                   connection.close();
           } catch (SQLException e) {
           	
           }
       }
       return person;
	}
	
	public static List<Person> getPersonFromMusic(int idMusic) {
		List<Person> p = new ArrayList<>();
		Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        String query = "select distinct persone.*\n"
       	 	+ "from persone, colonne_sonore, composizionicolonna, interpretazionicolonna\n"
       	 	+ "where (persone.idPersona = composizionicolonna.idPersona\n"
       	 	+ "   or persone.idPersona = interpretazionicolonna.idPersona)\n"
       		+ "and (composizionicolonna.idColonna = colonne_sonore.idColonna \n"
       		+ "	or interpretazionicolonna.idColonna = colonne_sonore.idColonna)\n"
       		+ "and colonne_sonore.idColonna = ?";
       
        try {
        	statement = connection.prepareStatement(query);
        	statement.setInt(1, idMusic);
        	ResultSet result = statement.executeQuery();
        	while(result.next()) {
        		Person person = new Person();
        		person.setId(result.getInt("idPersona"));
        		person.setName(result.getString("Nome"));
        		person.setSurname(result.getString("Cognome"));
        		person.setBirthDay(result.getDate("DataDiNascita"));
        		p.add(person);
            }
        }
        catch (SQLException e) {
        	
       }
       finally {
           try {
               if (statement != null) 
                   statement.close();
               if (connection!= null)
                   connection.close();
           } catch (SQLException e) {
           
           }
       }
       return p;
	}

	public static List<StreamingService> getProductAviability(int idProduct) {
		List<StreamingService> list = new ArrayList<>();
		Connection connection = DBConnection.getConnection();
       PreparedStatement statement = null;
       String query = "select servizi_streaming.*\n"
       		+ "from servizi_streaming, disponibilitaprodotti\n"
       		+ "where servizi_streaming.NomeServizio = disponibilitaprodotti.NomeServizio\n"
       		+ "and disponibilitaprodotti.idProdotto = ?;";
       
       try {
       	statement = connection.prepareStatement(query);
       	statement.setInt(1, idProduct);
           ResultSet result = statement.executeQuery();
           while(result.next()) {
           	StreamingService str = new StreamingService();
           	str.setName(result.getString("NomeServizio"));
           	str.setWebSite(result.getString("SitoWeb"));
           	list.add(str);
           }
       }
       catch (SQLException e) {
       	
       }
       finally {
           try {
               if (statement != null) 
                   statement.close();
               if (connection!= null)
                   connection.close();
           } catch (SQLException e) {
           }
       }
       return list;
	}
	
	public static List<Person> getActorsForProduct(int idProduct) {
		List<Person> actors = new ArrayList<>();
		Connection connection = DBConnection.getConnection();
	       PreparedStatement statement = null;
	       String query = "select persone.* "
	       		+ "from persone, recitazioni "
	       		+ "where recitazioni.idProdotto = ? "
	       		+ "and recitazioni.idPersona = persone.idPersona;";
	       
	       try {
	       	statement = connection.prepareStatement(query);
	       	statement.setInt(1, idProduct);
	           ResultSet result = statement.executeQuery();
	           while(result.next()) {
	        	   Person p = new Person();

	        	   p.setId(result.getInt("idPersona"));
	        	   p.setName(result.getString("Nome"));
	        	   p.setSurname(result.getString("Cognome"));
	        	   p.setBirthDay(result.getDate("DataDiNascita"));
	        	   actors.add(p);
	           }
	       }
	       catch (SQLException e) {
	       	
	       }
	       finally {
	           try {
	               if (statement != null) 
	                   statement.close();
	               if (connection!= null)
	                   connection.close();
	           } catch (SQLException e) {
	           
	           }
	       }
		return actors;
	}
	
	public static List<Person> getWritersForProduct(int idProduct) {
		List<Person> writers = new ArrayList<>();
		Connection connection = DBConnection.getConnection();
	       PreparedStatement statement = null;
	       String query = "select persone.* "
	       		+ "from persone, sceneggiature "
	       		+ "where sceneggiature.idProdotto = ? "
	       		+ "and sceneggiature.idPersona = persone.idPersona;";
	       
	       try {
	       	statement = connection.prepareStatement(query);
	       	statement.setInt(1, idProduct);
	           ResultSet result = statement.executeQuery();
	           while(result.next()) {
	        	   Person p = new Person();

	        	   p.setId(result.getInt("idPersona"));
	        	   p.setName(result.getString("Nome"));
	        	   p.setSurname(result.getString("Cognome"));
	        	   p.setBirthDay(result.getDate("DataDiNascita"));
	        	   writers.add(p);
	           }
	       }
	       catch (SQLException e) {
	       	
	       }
	       finally {
	           try {
	               if (statement != null) 
	                   statement.close();
	               if (connection!= null)
	                   connection.close();
	           } catch (SQLException e) {

	           }
	       }
		return writers;
	}
	
	public static List<Music> getMusicForProduct(int idProduct) {
		List<Music> music= new ArrayList<>();
		Connection connection = DBConnection.getConnection();
	       PreparedStatement statement = null;
	       String query = "select colonne_sonore.*\n"
	       		+ "from colonne_sonore, repartiaudio\n"
	       		+ "where repartiaudio.idColonna = colonne_sonore.idColonna\n"
	       		+ "and repartiaudio.idProdotto = ?";
	       
	       try {
	       	statement = connection.prepareStatement(query);
	       	statement.setInt(1, idProduct);
	           ResultSet result = statement.executeQuery();
	           while(result.next()) {
	        	   Music m = new Music();
	        	   m.setIdMusic(result.getInt("idColonna"));
	        	   m.setTitle(result.getString("Titolo"));
	        	   music.add(m);
	           }
	       }
	       catch (SQLException e) {
	       
	       }
	       finally {
	           try {
	               if (statement != null) 
	                   statement.close();
	               if (connection!= null)
	                   connection.close();
	           } catch (SQLException e) {
	           	
	           }
	       }
		return music;
	}
	
	public static List<Product> getProductByPerson(int idPerson){
		 List<Product> products = new ArrayList<>();
	        
	        Connection connection = DBConnection.getConnection();
	        PreparedStatement statement = null;
	        String query = "select prodotti.*\n"
	        		+ "from prodotti, recitazioni, sceneggiature\n"
	        		+ "where (recitazioni.idProdotto = prodotti.idProdotto\n"
	        		+ "and sceneggiature.idProdotto = prodotti.idProdotto\n"
	        		+ "and (recitazioni.idPersona = ?\n"
	        		+ "or sceneggiature.idPersona = ?))\n"
	        		+ "or prodotti.idPersona = ?\n"
	        		+ "group by prodotti.idProdotto\n";
	        try {
	            statement = connection.prepareStatement(query);
	            statement.setInt(1, idPerson);
	            statement.setInt(2, idPerson);
	            statement.setInt(3, idPerson);
	            ResultSet result = statement.executeQuery();
	            while (result.next()) {
	                Product sp = new Product();
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
	        }
	        catch (SQLException e) {
	        	
	        }
	        finally {
	            try {
	                if (statement != null) 
	                    statement.close();
	                if (connection!= null)
	                    connection.close();
	            } catch (SQLException e) {
	            	
	            }
	        }
		return products;
	}
	
	public static Music getMusicfromId(final int id) {
		Music music  = null;
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = null;
		String query = "select colonne_sonore.*\n"
				+ "from colonne_sonore\n"
				+ "where colonne_sonore.idColonna = ?";
       
		try {
       	   statement = connection.prepareStatement(query);
       	   statement.setInt(1, id);
              ResultSet result = statement.executeQuery();
              if(result.next()) {
           	      music = new Music();
           	      music.setIdMusic(result.getInt("idColonna"));
           	      music.setTitle(result.getString("Titolo"));
              }
		}
		catch (SQLException e) {
			
		}
       finally {
           try {
               if (statement != null) 
                   statement.close();
               if (connection!= null)
                   connection.close();
           } catch (SQLException e) {
        
           }
       }
       return music;
	}
	
}

package mdbwatch.controller;
/**
 * Controller fot productView.fxml
 */

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import mdbwatch.common.ViewChanger;
import mdbwatch.model.Music;
import mdbwatch.model.Person;
import mdbwatch.model.Product;
import mdbwatch.model.StreamingService;
import mdbwatch.sql.SQLAdd;
import mdbwatch.sql.SQLGet;
import mdbwatch.sql.SQLVerify;

public class ProductViewController {
	
	
	private int idProduct;
	private Product prod;
	private ViewChanger changer;
	private String username;
	private FXMLLoader loader;

	
	@FXML Label name, year, avg, season, ep, plot, actorLabel, streamingLabel, directorLabel;
	@FXML VBox streamingBox, actorBox, writerBox, musicBox;
	@FXML Hyperlink director, fromSerie, production;
	@FXML MenuButton voteMenu;
	@FXML MenuItem one, two, three, four, five;
	@FXML Button voteButton, addWatchlistButton, tvEp;
	@FXML MenuItem streaming, watchlist, home;

	/**
	 * Pass parameter.
	 * @param username of user
	 * @param id of Product to upload
	 * @param vc for change view
	 */
	ProductViewController(String username, int id, ViewChanger vc) {
		this.idProduct = id;
		this.changer = vc;
		this.username = username;
	}

	/**
	 * Initialize the view.
	 */
	@FXML void initialize() {
		this.prod = SQLGet.getProductById(this.idProduct);
		
		this.name.setText(this.prod.getTitle());
		this.plot.setText("Trama: " + this.prod.getPlot());
		this.plot.setWrapText(true);
		if (SQLVerify.isInWatchlistProduct(username, idProduct)) {
			this.addWatchlistButton.setDisable(true);
		} else { 
			this.addWatchlistButton.setOnAction(e -> {
				addWatchlistProduct();
				});
		}
		
		
		if(this.prod.getYear() != 0) {
			this.tvEp.setDisable(true);
			this.tvEp.setVisible(false);
			
			this.year.setText(Integer.toString(this.prod.getYear()));
			this.production.setText(this.prod.getProduction());
			
			Person direc = SQLGet.getPersonById(this.prod.getIdDirector());
			if(direc != null) {
				this.director.setText(direc.getName() + " " + direc.getSurname());
				this.director.setOnAction (e -> {
					try {
						this.goToPersonView(direc.getId());
					} catch (IOException e1) {
					}
				});
			}
			if(this.prod.getIdSerie() != 0) {
				this.ep.setText("Episodio: " + this.prod.getNumber());
				this.season.setText("Stagione: "+ this.prod.getSeason());
				Product st = SQLGet.getProductById(this.prod.getIdSerie());
				this.fromSerie.setText(st.getTitle());
			} else {
				this.ep.setDisable(true);
				this.ep.setText("");
				this.season.setDisable(true);
				this.season.setText("");
				this.fromSerie.setDisable(true);
				this.fromSerie.setText("");
			} 
			
			List<StreamingService> streaming = SQLGet.getProductAvalability(this.prod.getIdProduct());
			for(final StreamingService s : streaming) {
				this.streamingBox.getChildren().add(new Label(s.getName()));
			}
			
			if(SQLVerify.isVoteExsisting(username, idProduct)) {
				this.voteMenu.setDisable(true);
				this.voteButton.setDisable(true);
			}
			avg.setText("Media voto: " + Long.toString(SQLGet.getAverageProduct(this.prod.getIdProduct())) + " / 5");
			
			List<Person> person = SQLGet.getActorsForProduct(idProduct);
			for(final Person p : person) {
				Hyperlink hp = new Hyperlink(p.getName() + " " + p.getSurname());
				this.actorBox.getChildren().add(0, hp);
				hp.setOnAction (e -> {
					try {
						this.goToPersonView(p.getId());
					} catch (IOException e1) {
					}
				});
			}
			person = SQLGet.getWritersForProduct(idProduct);
			for(final Person p : person) {
				Hyperlink hp = new Hyperlink(p.getName() + " " + p.getSurname());
				this.writerBox.getChildren().add(0, hp);
				hp.setOnAction (e -> {
					try {
						this.goToPersonView(p.getId());
					} catch (IOException e1) {
					}
				});

			}
			List<Music> music = SQLGet.getMusicForProduct(idProduct);
			for(final Music m : music) {
				Hyperlink hp = new Hyperlink(m.getTitle());
				hp.setOnAction(a -> {
					loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/musicView.fxml"));
					loader.setControllerFactory(c -> {
						return new MusicViewController(this.username, m.getIdMusic() , this.changer);
					});
					try {
						this.changer.loadNewStage(loader.load());
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				this.musicBox.getChildren().add(0, hp);
				}
		} else {
			
			this.voteButton.setDisable(true);
			this.voteButton.setVisible(false);
			this.voteMenu.setDisable(true);
			this.voteMenu.setVisible(false);
			
			this.director.setDisable(true);
			this.director.setVisible(false);
			this.directorLabel.setVisible(false);
			
			this.year.setVisible(false);
			this.actorLabel.setVisible(false);
			this.avg.setVisible(false);
			this.actorBox.setVisible(false);
			
			this.fromSerie.setDisable(true);
			this.fromSerie.setVisible(false);
			this.season.setVisible(false);
			this.ep.setVisible(false);
			this.streamingBox.setVisible(false);
			this.streamingLabel.setVisible(false);
			
			
		}
		
	} 
	
	/**
	 * Add the product on user's watchlist.
	 */
	private void addWatchlistProduct() {
		SQLAdd.addOnWatchlist(username, idProduct);
		this.addWatchlistButton.setDisable(true);
	}

	/**
	 * Load Person's view.
	 * @param id of person to upload information
	 * @throws IOException common IO exception
	 */
	private void goToPersonView(int id) throws IOException {
		loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/personView.fxml"));
		loader.setControllerFactory(c -> {
			return new PersonController(this.username, id, this.changer);
		});
		this.changer.loadNewStage(loader.load());
	}

	/**
	 * Change the vote in VoteMenu
	 * @param e to get the vote
	 */
	@FXML void selectVote(final ActionEvent e) {
		this.voteMenu.setText(((MenuItem)e.getSource()).getText());
	}

	/**
	 * Add the text in voteMenu to product's votes.
	 */
	@FXML void vote() {
		SQLAdd.addVote(this.username, this.idProduct, Integer.parseInt(this.voteMenu.getText()));
		this.voteMenu.setText("-");
		this.voteMenu.setDisable(true);
		this.voteButton.setDisable(true);
	}

	/**
	 * If the product is a tv's serie, load a searchResult's view with episodes of the product.
	 * @throws IOException
	 */
	@FXML void goToEpisodies() throws IOException {
		loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/searchResult.fxml"));
		loader.setControllerFactory(c -> {
			return new SearchResultController(this.username, "Episodi:", SQLGet.getEpisodies(idProduct), this.changer);
		});
		this.changer.loadNewStage(loader.load());
	}

	/**
	 * Load a searchResult's view with product of production.
	 * @throws IOException common IO exception.
	 */
	@FXML void goToProductionProduct() throws IOException {
		loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/searchResult.fxml"));
		loader.setControllerFactory(c -> {
			return new SearchResultController(this.username, "Prodotti da " + this.prod.getProduction() + ":"
		, SQLGet.getProductForProduction(this.prod.getProduction()), this.changer);
		});
		this.changer.loadNewStage(loader.load());
	}

	/**
	 * Action performed for MenuItem.
	 * Change the view according with MenuItem.
	 * @param e for get source's MenuItem
	 * @throws IOException common IO exception
	 */
	@FXML void actionOnMenuItem (final ActionEvent e) throws IOException {
		if (e.getSource().equals(this.watchlist)) {
			loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/searchResult.fxml"));
			loader.setControllerFactory(c -> {
				return new SearchResultController(this.username, "La tua Watchlist:", SQLGet.getWatchlist(this.username), this.changer);
			});
		} else if (e.getSource().equals(this.streaming)) {
			loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/searchResult.fxml"));
			loader.setControllerFactory(c -> {
				return new SearchResultController(this.username, "Sui tuoi servizi:", SQLGet.getProductByUserService(this.username), this.changer);
			});
		} else if (e.getSource().equals(this.home)) {
			loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/home.fxml"));
			loader.setControllerFactory(c -> {
				return new HomeController(this.username, this.changer);
			});
		}
	this.changer.loadNewStage(loader.load());
	}
}

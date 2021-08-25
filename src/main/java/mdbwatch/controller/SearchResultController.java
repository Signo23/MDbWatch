package mdbwatch.controller;
/**Controller of searchResult.fxml*/
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import mdbwatch.common.ViewChanger;
import mdbwatch.model.Product;
import mdbwatch.sql.SQLGet;

public class SearchResultController {
	
	private String username;
	private String labelText;
	private List<Product> result;
	private ViewChanger changer;
	private Map<Hyperlink, Integer> link;
	private FXMLLoader loader;
	
	@FXML VBox filmPane, seriesPane, epTVPane;
	@FXML Label label;
	@FXML MenuItem streaming, watchlist, home;

	/**
	 * Pass parameter.
	 * @param username of user
	 * @param label for initialize the view
	 * @param searchResult to load
	 * @param vc for change the view
	 */
	public SearchResultController(String username, String label, List<Product> searchResult, ViewChanger vc) {
		this.labelText = label;
		this.result = searchResult;
		this.changer = vc;
		this.username = username;
		this.link = new HashMap<>();
	}

	/**
	 * Initialize the view with search's result.
	 */
	@FXML void initialize() {
		this.label.setText(this.labelText);
		if(!this.result.isEmpty()) {
			for (Product p : result) {
				Hyperlink hp = new Hyperlink(p.getTitle());
				hp.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/productView.fxml"));
						loader.setControllerFactory(c -> {
							return new ProductViewController(username, link.get((Hyperlink)event.getSource()), changer);
						});
						try {
							changer.loadNewStage(loader.load());
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					
				});
				this.link.put(hp, p.getIdProduct());
				if (p.getIdSerie() == 0) {
					if(p.getYear() == 0) {
						this.seriesPane.getChildren().add(0, hp);
					} else {
					    this.filmPane.getChildren().add(0, hp);
					}
				} else {
					this.epTVPane.getChildren().add(0, hp);
				}
			} 
		}
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

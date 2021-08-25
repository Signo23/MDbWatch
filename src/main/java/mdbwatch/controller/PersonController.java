package mdbwatch.controller;
/**Controller for person.fxml*/
import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import mdbwatch.common.ViewChanger;
import mdbwatch.model.Person;
import mdbwatch.model.Product;
import mdbwatch.sql.SQLGet;

public class PersonController {
	private FXMLLoader loader;
	private ViewChanger changer;
	private String username;
	private Person person;
	
	@FXML VBox productPane;
	@FXML MenuItem streaming, watchlist, home;
	@FXML Label name, birthday;

	/**
	 * Pass username, peson's id and view changer.
	 * @param username of user
	 * @param id of person to upload the info 
	 * @param changer for change the view
	 */
	PersonController(String username, int id, ViewChanger changer) {
		this.username = username;
		this.changer = changer;
		this.person = SQLGet.getPersonById(id);
	}

	/**
	 * Initialize the view.
	 */
	@FXML void initialize() {
		this.name.setText(this.person.getName() + " " + this.person.getSurname());
		this.birthday.setText(this.person.getBirthDay().toString());
		List<Product> products = SQLGet.getProductByPerson(this.person.getId());
		for (final Product p : products) {
			Hyperlink product = new Hyperlink(p.getTitle());
			product.setOnAction(e -> {
				FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/productView.fxml"));
				loader.setControllerFactory(c -> {
					return new ProductViewController(username, p.getIdProduct(), changer);
				});
				try {
					this.changer.loadNewStage(loader.load());
				} catch (IOException e1) {
				}
			});
			this.productPane.getChildren().add(0, product);
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

package mdbwatch.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import mdbwatch.common.ViewChanger;
import mdbwatch.sql.SqlQuery;

public class HomeController {
	
	private String username;
	private ViewChanger changer;
	private FXMLLoader loader;
	
	@FXML MenuItem streamingService, watchlist;
	@FXML Label label;
	@FXML TextField search;
	@FXML Menu option;
	
	public HomeController(final String username, final ViewChanger vc) {
		this.username = username;
		this.changer = vc;
	}

	@FXML void initialize() {
		this.label.setText("Ciao, " + this.username);
		this.option.setVisible(false);
	}

	@FXML void actionOnMenuItem (final ActionEvent e) throws IOException {
		if (e.getSource().equals(this.streamingService)) {
			loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/streamingSettings.fxml"));
			loader.setControllerFactory(c -> {
				return new StreamingSettingsController(this.username ,this.changer);
				});
			} else if (e.getSource().equals(watchlist)) {
				loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/searchResult.fxml"));
				loader.setControllerFactory(c -> {
					return new SearchResultController(this.username, "La tua Watchlist:", SqlQuery.getWatchlist(this.username), this.changer);
				});
			} else {
				FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/searchResult.fxml"));
				loader.setControllerFactory(c -> {
					return new SearchResultController(this.username, "Sui tuoi servizi:", SqlQuery.getProductForUserService(this.username), this.changer);
				});
			}
		this.changer.loadNewStage(loader.load());
	}
	
	@FXML void search () throws IOException {
		loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/searchResult.fxml"));
		loader.setControllerFactory(c -> {
			return new SearchResultController(this.username, "Risultati ricerca:", SqlQuery.searchProductByTitle(this.search.getText()), this.changer);
		});
		this.changer.loadNewStage(loader.load());
	}
	
	@FXML void searchEnter(KeyEvent k) throws IOException {
		if(k.getCode().equals(KeyCode.ENTER)) {
			this.search();
		}
	}

}

package mdbwatch.controller;

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
import mdbwatch.model.Music;
import mdbwatch.model.Person;
import mdbwatch.sql.SQLGet;

public class MusicViewController {
	
	private String username;
	private ViewChanger changer;
	private Music music;
	private FXMLLoader loader;
	
	@FXML MenuItem streaming, watchlist, home;
	@FXML Label title;
	@FXML VBox personPane;
	
	MusicViewController(String username, int id, ViewChanger changer) {
		this.username = username;
		this.changer = changer;
		this.music = SQLGet.getMusicfromId(id);
	}
	
	public void initialize() {
		this.title.setText(this.music.getTitle());
		List<Person> person = SQLGet.getPersonFromMusic(this.music.getIdMusic());
		for(final Person p : person) {
			Hyperlink hp = new Hyperlink(p.getName() + " " + p.getSurname());
			hp.setOnAction(a -> {

				loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/personView.fxml"));
				loader.setControllerFactory(c -> {
					return new PersonController(this.username, p.getId(), this.changer);
				});
				try {
					this.changer.loadNewStage(loader.load());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			this.personPane.getChildren().add(0, hp);
		}
	}
	
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

package mdbwatch.controller;


import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import mdbwatch.common.ViewChanger;
import mdbwatch.model.Person;
import mdbwatch.model.SingleProduct;
import mdbwatch.model.StreamingService;
import mdbwatch.sql.SqlQuery;

public class ProductViewController {
	
	
	private int idProduct;
	private ViewChanger changer;
	private String username;
	
	@FXML Label name, year, avg, season, ep, plot, production;
	@FXML VBox streamingBox, actorBox, writerBox, musicBox;
	@FXML Hyperlink director, fromSerie;
	@FXML MenuButton voteMenu;
	@FXML MenuItem one, two, three, four, five;
	@FXML Button voteButton;

	ProductViewController(String username, int id, ViewChanger vc) {
		this.idProduct = id;
		this.changer = vc;
		this.username = username;
	}
	
	@FXML void initialize() {
		if(SqlQuery.searchById(this.idProduct) instanceof SingleProduct) {
			SingleProduct prod =(SingleProduct) SqlQuery.searchById(this.idProduct);
			this.name.setText(prod.getTitle());
			this.year.setText(Integer.toString(prod.getYear()));
			this.plot.setText("Trama: " + prod.getPlot());
			this.plot.setWrapText(true);
			this.production.setText("Produzione: " + prod.getProduction());
			Person director = SqlQuery.searchPersonById(prod.getIdDirector());
			if(director != null) {
				this.director.setText(director.getName() + " " +director.getSurname());
			}
			if(prod.getIdSerie() != 0) {
				this.ep.setText("Episodio: " + prod.getNumber());
				this.season.setText("Stagione: "+ prod.getSeason());
				this.fromSerie.setText(SqlQuery.searchSerieById(prod.getIdSerie()).getTitle());
			} else {
				this.ep.setDisable(true);
				this.ep.setText("");
				this.season.setDisable(true);
				this.season.setText("");
				this.fromSerie.setDisable(true);
				this.fromSerie.setText("");
			} 
			List<StreamingService> streaming = SqlQuery.searchProductAviability(prod.getIdProduct());
			for(StreamingService s : streaming) {
				this.streamingBox.getChildren().add(new Label(s.getName()));
			}
			
			if(SqlQuery.isVoteExsisting(username, idProduct)) {
				this.voteMenu.setDisable(true);
				this.voteButton.setDisable(true);
			}
			avg.setText("Media voto: " + Long.toString(SqlQuery.getAverageProduct(prod.getIdProduct())) + " / 5");
		}
		
	} 
	
	@FXML void selectVote(final ActionEvent e) {
		this.voteMenu.setText(((MenuItem)e.getSource()).getText());
	}
	
	@FXML void vote() {
		SqlQuery.addVote(this.username, this.idProduct, Integer.parseInt(this.voteMenu.getText()));
		this.voteMenu.setText("-");
		this.voteMenu.setDisable(true);
		this.voteButton.setDisable(true);
	}
}

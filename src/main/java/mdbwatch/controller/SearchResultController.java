package mdbwatch.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import mdbwatch.common.ViewChanger;
import mdbwatch.model.Product;
import mdbwatch.model.SingleProduct;
import mdbwatch.model.SerieTv;

public class SearchResultController {
	
	String username;
	String labelText;
	List<Product> result;
	ViewChanger changer;
	Map<Hyperlink, Integer> link;
	
	@FXML VBox filmPane, seriesPane, epTVPane;
	@FXML Label label;
	
	public SearchResultController(String username, String label, List<Product> searchResult, ViewChanger vc) {
		this.labelText = label;
		this.result = searchResult;
		this.changer = vc;
		this.username = username;
		this.link = new HashMap<>();
	}
	
	@FXML void initialize(){
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
				if (p instanceof SingleProduct ) {
					if (((SingleProduct)p).getIdSerie() == 0) {
						this.filmPane.getChildren().add(0, hp);
					} else {
						this.epTVPane.getChildren().add(0, hp);
					}
				} else if (p instanceof SerieTv) {
					this.seriesPane.getChildren().add(0, hp);
				}
			} 
		} else {
			this.filmPane.getChildren().add(0, new Label("Nessun risultato"));
			this.epTVPane.getChildren().add(0, new Label("Nessun risultato"));
			this.seriesPane.getChildren().add(0, new Label("Nessun risultato"));
		}
	}
}

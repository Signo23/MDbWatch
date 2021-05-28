package mdbwatch.controller;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import mdbwatch.model.Product;
import mdbwatch.model.SingleProduct;
import mdbwatch.model.SerieTv;

public class SearchResultController {
	
	String labelText;
	List<Product> result;
	
	@FXML VBox filmPane, seriesPane, epTVPane;
	@FXML Label label;
	
	public SearchResultController(String label, List<Product> searchResult) {
		this.labelText = label;
		this.result = searchResult;
	}
	
	@FXML void initialize(){
		this.label.setText(this.labelText);
		if(!this.result.isEmpty()) {
			for (Product p : result) {
				Hyperlink hp = new Hyperlink(p.getTitle());
				hp.setOnAction(null);
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

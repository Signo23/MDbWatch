package mdbwatch.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import mdbwatch.common.ViewChanger;

public class HomeController {
	
	private String username;
	private ViewChanger changer;
	
	@FXML MenuItem streamingService;
	@FXML Parent root;
	@FXML Label label;
	
	public HomeController(final String username, final ViewChanger vc) {
		this.username = username;
		this.changer = vc;
	}
	@FXML
	public void initialize() {
		this.label.setText("Ciao, " + this.username);
	}
	@FXML
	public void actionOnMenuItem (final ActionEvent e) {
		 try {
	            if (e.getSource().equals(this.streamingService)) {
	            	FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/streamingSettings.fxml"));
	            	loader.setControllerFactory(c -> {
	            		return new StreamingSettingsController(this.username ,this.changer);
	            	});
	                this.changer.loadNewStage(loader.load());
	                }
//	            final Scene scene = new Scene(root);
//	            stage.setScene(scene);
//	            stage.show();
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	}

}
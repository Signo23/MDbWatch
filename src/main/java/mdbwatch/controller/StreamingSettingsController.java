package mdbwatch.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import mdbwatch.common.ViewChanger;

public class StreamingSettingsController {
	
	private ViewChanger changer;
	private String username;
	
	@FXML CheckBox netflix;
	
	public StreamingSettingsController(String username, ViewChanger vc) {
		this.changer = vc;
		this.username = username;
	}

	@FXML public void next() throws IOException {
		FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/home.fxml"));
    	loader.setControllerFactory(c -> {
    		return new HomeController(this.username, this.changer);
    	});
    	this.changer.loadNewStage(loader.load());
	}
}

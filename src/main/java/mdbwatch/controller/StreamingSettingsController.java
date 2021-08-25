package mdbwatch.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import mdbwatch.common.ViewChanger;
import mdbwatch.sql.SQLAdd;

public class StreamingSettingsController {
	
	private ViewChanger changer;
	private String username;
	
	@FXML CheckBox netflix, prime_video, disney_plus, chili, tim_vision, rakutenTv, appleTv_plus, now, rai, infinity;
	List<CheckBox> services;
	
	public StreamingSettingsController(String username, ViewChanger vc) {
		this.changer = vc;
		this.username = username;
	}
	
	public void initialize() {
		this.services = new ArrayList<>();
		this.services.add(appleTv_plus);
		this.services.add(disney_plus);
		this.services.add(netflix);
		this.services.add(prime_video);
		this.services.add(rakutenTv);
		this.services.add(chili);
		this.services.add(infinity);
		this.services.add(now);
		this.services.add(rai);
		this.services.add(tim_vision);
	}

	@FXML public void next() throws IOException {
		for(final CheckBox cb : this.services) {
			if(cb.isSelected()) {
				SQLAdd.addUserStreamingService(username, cb.getText());
			}
		}

		FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/home.fxml"));
    	loader.setControllerFactory(c -> {
    		return new HomeController(this.username, this.changer);
    	});
    	this.changer.loadNewStage(loader.load());
	}
}

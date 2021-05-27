package mdbwatch.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mdbwatch.common.ViewChanger;
import mdbwatch.sql.SqlQuery;

public class SignInController {
	
	private ViewChanger changer;

	@FXML TextField username;
    @FXML PasswordField password;
    @FXML Label errorLabel;
    
    public SignInController(final ViewChanger vc) {
    	this.changer = vc;
    }
    
    @FXML void signIn() throws IOException {
    	if(!SqlQuery.isUserAlreayExsist(this.username.getText())) {
    		SqlQuery.addUser(this.username.getText(), this.password.getText());
    		FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/streamingSettings.fxml"));
        	loader.setControllerFactory(c -> {
        		return new StreamingSettingsController(this.username.getText(), this.changer);
        	});
            this.changer.loadNewStage(loader.load());
    	} else {
    		this.errorLabel.setText("Il nome utente è già in uso");
    	}
    }
    
    @FXML void back() throws IOException {
    	FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/firstStage.fxml"));
    	loader.setControllerFactory(c -> {
    		return new FirstStageController(this.changer);
    	});
        this.changer.loadNewStage(loader.load());
	}
}


package mdbwatch.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mdbwatch.common.ViewChanger;
import mdbwatch.sql.SqlQuery;

public class SignInController {
	
	private ViewChanger changer;
	private Parent root;
    @FXML TextField username;
    @FXML PasswordField password;
    
    public SignInController(final ViewChanger vc) {
    	this.changer = vc;
    }
    
    @FXML void signIn() throws IOException {
    	if(!SqlQuery.verifyUser(this.username.getText(), password.getText())) {
    		SqlQuery.addUser(this.username.getText(), this.password.getText());
    		FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/home.fxml"));
        	loader.setControllerFactory(c -> {
        		return new HomeController(this.username.getText(), this.changer);
        	});
            root = loader.load();
            this.changer.loadNewStage(root);
    	}
    }
    
    @FXML void back() throws IOException {
    	FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/firstStage.fxml"));
    	loader.setControllerFactory(c -> {
    		return new FirstStageController(this.changer);
    	});
        root = loader.load();
        this.changer.loadNewStage(root);
	}
}


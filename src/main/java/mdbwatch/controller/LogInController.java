package mdbwatch.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import mdbwatch.common.ViewChanger;
import mdbwatch.sql.SqlQuery;

public class LogInController {
	
	private ViewChanger changer;
	private Parent root;
    @FXML TextField username;
    @FXML PasswordField password;
    @FXML Label error;
    
    public LogInController(final ViewChanger vc) {
    	this.changer = vc;
    }
    
    @FXML void logIn() throws IOException {
    	if(SqlQuery.verifyUser(this.username.getText(), password.getText())) {
    		FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/home.fxml"));
        	loader.setControllerFactory(c -> {
        		return new HomeController(this.username.getText(), this.changer);
        	});
            root = loader.load();
            this.changer.loadNewStage(root);
    	} else {
    		this.error.setText("Nome utente o password errati");
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
    
    @FXML void toPasswordField(KeyEvent k) {
    	if(k.getCode().equals(KeyCode.ENTER)) {
    		this.password.requestFocus();
    	}
    }
    
    @FXML void enterLogIn(KeyEvent k) throws IOException {
        if (k.getCode().equals(KeyCode.ENTER)) {
            logIn();
        }
    }
}

package mdbwatch.controller;
/**Controller for signIn.fxml*/
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import mdbwatch.common.ViewChanger;
import mdbwatch.sql.SQLAdd;
import mdbwatch.sql.SQLVerify;

public class SignInController {
	
	private ViewChanger changer;

	@FXML TextField username;
    @FXML PasswordField password;
    @FXML Label errorLabel;

    /**
     * Pass view changer.
     * @param vc for change the view
     */
    public SignInController(final ViewChanger vc) {
    	this.changer = vc;
    }

    /**
     * Control if Username already exist.
     * If the username exsist use errorLable to comunicate it.
     * If username not exsist create a new User with password in the PasswordField.
     * @throws IOException common IO excpetion
     */
    @FXML void signIn() throws IOException {
    	if(!SQLVerify.isUserAlreayExsist(this.username.getText())) {
    		SQLAdd.addUser(this.username.getText(), this.password.getText());
    		FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/streamingSettings.fxml"));
        	loader.setControllerFactory(c -> {
        		return new StreamingSettingsController(this.username.getText(), this.changer);
        	});
            this.changer.loadNewStage(loader.load());
    	} else {
    		this.errorLabel.setText("Il nome utente è già in uso");
    	}
    }

    /**
     * Load First Stage.
     * @throws IOException common IO exception
     */
    @FXML void back() throws IOException {
    	FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/firstStage.fxml"));
    	loader.setControllerFactory(c -> {
    		return new FirstStageController(this.changer);
    	});
        this.changer.loadNewStage(loader.load());
	}
}


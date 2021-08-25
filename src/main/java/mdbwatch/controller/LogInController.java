package mdbwatch.controller;
/**
 * Controller for logIn.fxml.
 */
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
import mdbwatch.sql.SQLVerify;

public class LogInController {
	
	private ViewChanger changer;
	private Parent root;
    @FXML TextField username;
    @FXML PasswordField password;
    @FXML Label error;

    /**
     * Pass the ViewChanger.
     * @param vc for change the view
     */
    public LogInController(final ViewChanger vc) {
    	this.changer = vc;
    }

    /**
     * Control if user exsist and if the password is correct.
     * If the password is correct and user exist launch the home's view.
     * If the password is not correct or user doesn't exist use the Label error for comunicate it
     * @throws IOException common IO exception
     */
    @FXML void logIn() throws IOException {
    	if(SQLVerify.verifyUser(this.username.getText(), password.getText())) {
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

    /**
     * Load fistStage's view.
     * @throws IOException common IO exception
     */
    @FXML void back() throws IOException {
    	FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/firstStage.fxml"));
    	loader.setControllerFactory(c -> {
    		return new FirstStageController(this.changer);
    	});
        root = loader.load();
        this.changer.loadNewStage(root);
	}

    /**
     * Control if enter's key was pressed on username's textField.
     * If it was pressed change the focus on password's PasswordField.
     * @param k key to control
     */
    @FXML void toPasswordField(KeyEvent k) {
    	if(k.getCode().equals(KeyCode.ENTER)) {
    		this.password.requestFocus();
    	}
    }

    /**
     * Control if enter's key was pressed on password's PasswordField.
     * If it was pressed change launch login().
     * @param k
     * @throws IOException
     */
    @FXML void enterLogIn(KeyEvent k) throws IOException {
        if (k.getCode().equals(KeyCode.ENTER)) {
            logIn();
        }
    }
}

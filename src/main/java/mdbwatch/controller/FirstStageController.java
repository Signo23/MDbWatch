package mdbwatch.controller;
/**
 * Controller for firstStage.fxml
 */
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import mdbwatch.common.ViewChanger;

public class FirstStageController {
	
	private ViewChanger changer;
	FXMLLoader loader;

    @FXML
    private Button logIn;

    /**
     * Pass a ViewChanger.
     * @param vc for change view
     */
    public FirstStageController(ViewChanger vc) {
    	this.changer = vc;
    }

    /**
     * Change view when click on logIn's button or signIn's button.
     * @param e event for get button
     * @throws IOException common IO exception
     */
    @FXML
    public final void clickOn(final ActionEvent e) throws IOException {
    	if (e.getSource().equals(logIn)) {
    		loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/logIn.fxml"));
            loader.setControllerFactory(c -> {
            	return new LogInController(this.changer);
            	});
            } else {
            	loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/signIn.fxml"));
            	loader.setControllerFactory(c -> {
            		return new SignInController(this.changer);
            		});
            	}
    	this.changer.loadNewStage(loader.load());  
        }
}

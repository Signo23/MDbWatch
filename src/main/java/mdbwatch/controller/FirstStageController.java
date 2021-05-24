package mdbwatch.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import mdbwatch.common.ViewChanger;

public class FirstStageController {
	
	private Parent root;
	private ViewChanger changer;
	FXMLLoader loader;

    @FXML
    private Button admin, user, signIn, logIn;
    @FXML
    private Label label;
    
    public FirstStageController(ViewChanger vc) {
    	this.changer = vc;
    }
    @FXML
    public final void clickOn(final ActionEvent e) {
        try {
            if (e.getSource().equals(admin)) {
                root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/admin.fxml"));
                } else if (e.getSource().equals(user)) {
                    root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/user.fxml"));
                    } else if (e.getSource().equals(logIn)) {
                    	loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/logIn.fxml"));
                        loader.setControllerFactory(c -> {
                        	return new LogInController(this.changer);
                        });
                        root = loader.load();
                        } else {
                        	loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/signIn.fxml"));
                            loader.setControllerFactory(c -> {
                            	return new SignInController(this.changer);
                            });
                            root = loader.load();
                            }
            this.changer.loadNewStage(root);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
}

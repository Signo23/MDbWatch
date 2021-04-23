package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLStartController {

    @FXML
    private Button admin, user, signIn, logIn;

    @FXML
    public void clickOn (ActionEvent e) throws Exception {
			Stage stage = (Stage) ((Button)e.getSource()).getScene().getWindow();
			Parent root;
			if(e.getSource().equals(admin)) {
				root = FXMLLoader.load(getClass().getResource("admin.fxml"));
			} else if (e.getSource().equals(user)){
				root = FXMLLoader.load(getClass().getResource("user.fxml"));
			} else if (e.getSource().equals(logIn)){
				root = FXMLLoader.load(getClass().getResource("logIn.fxml"));
			} else {
				root = FXMLLoader.load(getClass().getResource("signIn.fxml"));
			}
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
//	    	stage.close();
	    	}
}
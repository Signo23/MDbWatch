package org.openjfx;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLController {

    @FXML
    private Button admin;

    @FXML
    public void clickOnAdmin() {
    	Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("admin.fxml"));
			Stage stage = new Stage();
	        Scene scene = new Scene(root);	        
	        stage.setTitle("MDbWatch-Admin");
	        stage.setScene(scene);
	        stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
}
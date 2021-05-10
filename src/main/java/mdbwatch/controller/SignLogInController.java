package mdbwatch.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SignLogInController {
    @FXML
    Button nextLogIn, nextSignIn, prevLogIn, prevSignIn;
    
    @FXML
    public void click(ActionEvent e) throws Exception {
        Stage stage = (Stage) ((Button)e.getSource()).getScene().getWindow();
        Parent root;
        if(e.getSource().equals(nextLogIn)) {
            root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/userInterface.fxml"));
        } else if (e.getSource().equals(nextSignIn)){
            root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/userInterface.fxml"));
        } else if (e.getSource().equals(prevLogIn)){
            root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/user.fxml"));
        } else {
            root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/user.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
}

package mdbwatch.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FirstStageController {

    @FXML
    private Button admin, user, signIn, logIn;

    @FXML
    public final void clickOn(final ActionEvent e) {

        try {
            final Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
            Parent root;
            if (e.getSource().equals(admin)) {
                root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/admin.fxml"));
                } else if (e.getSource().equals(user)) {
                    root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/user.fxml"));
                    } else if (e.getSource().equals(logIn)) {
                        root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/logIn.fxml"));
                        } else {
                            root = FXMLLoader.load(ClassLoader.getSystemResource("layouts/signIn.fxml"));
                            }
            final Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            } catch (IOException e1) {
                e1.printStackTrace();
                }
//              stage.close();
        }
}

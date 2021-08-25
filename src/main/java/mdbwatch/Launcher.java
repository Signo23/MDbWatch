
package mdbwatch;
/** It Load the first View.*/
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import mdbwatch.common.ViewChanger;
import mdbwatch.controller.FirstStageController;
import mdbwatch.sql.SQLInit;

public class Launcher extends Application {
	

    @Override
    public final void start(final Stage primaryStage) throws Exception {
    	Stage stage = primaryStage;
    	ViewChanger vc = new ViewChanger(stage);
    	FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("layouts/firstStage.fxml"));
    	loader.setControllerFactory(c ->{
    		return new FirstStageController(vc);
    	});
        final Parent root = loader.load();
        stage.setTitle("MdbWatch");
        vc.loadNewStage(root);
        SQLInit.createDB();
    }
    public static void run(final String[] args) {
        launch(args);
    }

}
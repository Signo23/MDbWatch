package mdbwatch.common;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewChanger {

	private Stage stage;
	
	public ViewChanger(Stage stage) {
		this.stage = stage;
	}
	
	public void loadNewStage(Parent root) {
		this.stage.setScene(new Scene(root));
		this.stage.setResizable(false);
		this.stage.show();
	}
}

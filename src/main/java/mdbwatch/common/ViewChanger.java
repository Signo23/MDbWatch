package mdbwatch.common;
/**Change view */
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewChanger {

	private Stage stage;
	/**
	 * Initialize the stage for change view.
	 * @param stage starting stage
	 */
	public ViewChanger(Stage stage) {
		this.stage = stage;
	}

	/**
	 * Load root in the Stage.
	 * @param root of Scene to load
	 */
	public void loadNewStage(Parent root) {
		this.stage.setScene(new Scene(root));
		this.stage.setResizable(false);
		this.stage.show();
	}
}

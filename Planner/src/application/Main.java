package application;
	
import application.model.Schedule;
import application.model.Settings;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * The Main class is a public class extending javafx.application.Application that loads the Main.fxml view
 * and launches the application.
 * 
 * @author Stephanie Bassey, Lucian Williams, Azrah Al Rabeeah
 */
public class Main extends Application {
	public static Stage stage;

	/**
	 * Starts the application.
	 * 
	 * @param primaryStage The primary stage.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/Main.fxml"));
			primaryStage.setScene(new Scene(root, 800, 800));
			primaryStage.show();
			
			stage = primaryStage;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads the initial settings and launches the application.
	 * 
	 * @param args The String arguments to the application.
	 */
	public static void main(String[] args) {
		Schedule.initialize();
		Settings.loadSettings();
		
		launch(args);
	}
}

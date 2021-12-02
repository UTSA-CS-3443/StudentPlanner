package application.controller;

import application.Main;
import application.model.Schedule;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

/**
 * The MainController class is responsible for allowing the user to switch from the main welcome screen to 
 * one of the two available views. One button will switch the use to the settings view and the other to a view with their added schedule entries
 * 
 * @author Stephanie Bassey, Lucian Williams, Azrah Al Rabeeah
 */
public class MainController implements EventHandler<MouseEvent> {

	/**
	 * Method that listens for MouseEvents, specifically a mouse click on
	 * the image representing Settings, and switches the user to that view
	 * 
	 * @param event (MouseEvent)
	 */
	@Override
	public void handle(MouseEvent event) {
		try {
			Schedule.loadData();
			Parent root = FXMLLoader.load(Main.class.getResource("view/Settings.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}

	/**
	 * Method that listens for MouseEvents, specifically a mouse click on
	 * the image representing the view with the schedule entries, and then switches the user to that view
	 * 
	 * @param event (MouseEvent)
	 */
	public void switchToPriority(MouseEvent event) {
		try {
			Schedule.loadData();
			Parent root = FXMLLoader.load(Main.class.getResource("view/Priority.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}
}

package application.controller;

import application.Main;
import application.model.Schedule;
import application.model.Settings;
import application.model.Entry;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;
import javafx.scene.paint.Paint;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.lang.Math;

public class PriorityController implements EventHandler<MouseEvent>, Initializable {
	
	@FXML
	AnchorPane mainPane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//order entries by Settings.getPriorityOrdering()
		ArrayList<Entry> entries = (ArrayList<Entry>) Schedule.getEntries().clone();
		for (int i = 1; i < entries.size(); i++) {
			for (int j = 0; j < entries.size() - i; j++) {
				if (entries.get(j).getField(Settings.getPriorityOrdering()).getValue()
						.compareTo(entries.get(j + 1).getField(Settings.getPriorityOrdering()).getValue()) < 0) {
					Entry temp = entries.get(j);
					entries.set(j, entries.get(j + 1));
					entries.set(j + 1, temp);
				}
			}
		}
		//fill in entry fields in view from model (link model to view)
		if (entries.size() > 0) {
			mainPane.getChildren().add(largeEntry(130, 30,
					entries.get(0).getField(Settings.getPriorityTopLeft()).getValue(),
					entries.get(0).getField(Settings.getPriorityTopRight()).getValue(),
					entries.get(0).getName(),
					entries.get(0).getField(Settings.getPriorityCenter()).getValue(),
					entries.get(0).getField(Settings.getPriorityCenterBottom()).getValue(),
					entries.get(0).getField(Settings.getPriorityBottomLeft()).getValue(),
					entries.get(0).getField(Settings.getPriorityBottomRight()).getValue()));
			
		}
		for (int i = 0; i < entries.size(); i++) {
			
		}
	}

	@Override
	public void handle(MouseEvent event) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("view/Settings.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public void switchToCalendar(MouseEvent event) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("view/Calendar.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public void switchToList(MouseEvent event) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("view/List.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}
	
	public void switchToHome(MouseEvent event) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("view/Main.fxml"));
			Main.stage.setScene(new Scene(root, 800, 800));
			Main.stage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
	}

	private AnchorPane largeEntry(int x, int y, String topLeftText, String topRightText, String centerTopText,
			String centerText, String centerBottomText, String bottomLeftText, String bottomRightText) {

		Font smallFont = Font.font("System", FontWeight.BOLD, FontPosture.REGULAR, 10.0);
		Font titleFont = Font.font("System", FontWeight.BOLD, FontPosture.REGULAR, 16.0);

		AnchorPane temp = new AnchorPane();
		temp.setPrefWidth(310);
		temp.setPrefHeight(240);
		temp.setLayoutX(x);
		temp.setLayoutY(y);

		Rectangle rect = new Rectangle();
		rect.setWidth(310);
		rect.setHeight(240);
		rect.setFill(Paint.valueOf("dddddd"));
		temp.getChildren().add(rect);

		Label topLeft = new Label();
		topLeft.setFont(smallFont);
		topLeft.setText(topLeftText);
		topLeft.setPrefWidth(145);
		topLeft.setMaxHeight(30);
		topLeft.setLayoutX(5);
		topLeft.setLayoutY(5);
		topLeft.setAlignment(Pos.TOP_LEFT);
		topLeft.setTextAlignment(TextAlignment.LEFT);

		Label topRight = new Label();
		topRight.setFont(smallFont);
		topRight.setText(topRightText);
		topRight.setPrefWidth(145);
		topRight.setMaxHeight(30);
		topRight.setLayoutX(160);
		topRight.setLayoutY(5);
		topRight.setAlignment(Pos.TOP_RIGHT);
		topRight.setTextAlignment(TextAlignment.RIGHT);

		Label centerTop = new Label();
		centerTop.setFont(titleFont);
		centerTop.setText(centerTopText);
		centerTop.setPrefWidth(300);
		centerTop.setMaxHeight(50);
		centerTop.setLayoutX(5);
		centerTop.setLayoutY(Math.max(topLeft.getHeight(), topRight.getHeight()) + 10);
		centerTop.setAlignment(Pos.TOP_CENTER);
		centerTop.setTextAlignment(TextAlignment.CENTER);

		Label center = new Label();
		center.setFont(smallFont);
		center.setText(centerText);
		center.setPrefWidth(300);
		center.setLayoutX(5);
		center.setLayoutY(centerTop.getLayoutY() + centerTop.getHeight() + 5);
		center.setAlignment(Pos.TOP_CENTER);
		center.setTextAlignment(TextAlignment.CENTER);

		Label centerBottom = new Label();
		centerBottom.setFont(smallFont);
		centerBottom.setText(centerBottomText);
		centerBottom.setPrefWidth(300);
		centerBottom.setMaxHeight(30);
		centerBottom.setLayoutX(5);
		centerBottom.setAlignment(Pos.BOTTOM_CENTER);
		centerBottom.setTextAlignment(TextAlignment.CENTER);

		Label bottomLeft = new Label();
		bottomLeft.setFont(smallFont);
		bottomLeft.setText(bottomLeftText);
		bottomLeft.setPrefWidth(145);
		bottomLeft.setMaxHeight(30);
		bottomLeft.setLayoutX(5);
		bottomLeft.setLayoutY(235 - bottomLeft.getHeight());
		bottomLeft.setAlignment(Pos.BOTTOM_LEFT);
		bottomLeft.setTextAlignment(TextAlignment.LEFT);

		Label bottomRight = new Label();
		bottomRight.setFont(smallFont);
		bottomRight.setText(bottomRightText);
		bottomRight.setPrefWidth(145);
		bottomRight.setMaxHeight(30);
		bottomRight.setLayoutX(160);
		bottomRight.setLayoutY(235 - bottomRight.getHeight());
		bottomRight.setAlignment(Pos.BOTTOM_RIGHT);
		bottomRight.setTextAlignment(TextAlignment.RIGHT);

		centerBottom.setLayoutY(230 - Math.max(bottomLeft.getHeight(), bottomRight.getHeight()) - centerBottom.getHeight());
		center.setMaxHeight(centerBottom.getLayoutY() - centerTop.getLayoutY() - centerTop.getHeight() - 10);

		temp.getChildren().add(topLeft);
		temp.getChildren().add(topRight);
		temp.getChildren().add(centerTop);
		temp.getChildren().add(center);
		temp.getChildren().add(centerBottom);
		temp.getChildren().add(bottomLeft);
		temp.getChildren().add(bottomRight);

		return temp;
	}
}

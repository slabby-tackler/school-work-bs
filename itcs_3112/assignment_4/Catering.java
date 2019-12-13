/*
	Author: Nicholas Wade
	Date:   8-Apr-2017
*/

import java.util.ArrayList;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class Catering extends Application {
	@Override
	public void start (Stage primaryStage) {
		GridPane mainPane = new GridPane ();
		
		mainPane.setHgap (10);
		mainPane.setVgap (20);
		
		Font font = Font.font ("Arial", FontWeight.LIGHT, 12);
		
		ArrayList <RadioButton> entree_list = new ArrayList <RadioButton> (4);
		ArrayList <CheckBox> side_dish_list = new ArrayList <CheckBox> (4);
		ArrayList <RadioButton> dessert_list = new ArrayList <RadioButton> (3);
		
		String [] entrees = {"Herb Chicken", "BBQ Chicken", "Glazed Salmon", "Eggplant Roulade"};
		String [] side_dishes = {"Charred Broccoli", "Mac & Cheese", "Whipped Potatoes", "Roasted Vegetables"};
		String [] desserts = {"Coconut Tart", "Lemon Tart", "Almond Truffle"};
		
		ToggleGroup entree_group = new ToggleGroup ();
		ToggleGroup dessert_group = new ToggleGroup ();
		
		Label name_label = new Label ("Name:");
		Label phone_label = new Label ("Contact Number");
		Label guests_label = new Label ("Number of Guests:");
		Label cost_label = new Label ("Total Cost");
		Label entree_label = new Label ("Entree (Choose 1):");
		Label side_dish_label = new Label ("Side Dishes (Choose At Most 2):");
		Label dessert_label = new Label ("Dessert (Choose 1):");
		
		TextField name_field = new TextField ();
		TextField phone_field = new TextField ();
		TextField guest_field = new TextField ();
		TextField cost_field = new TextField ();
		
		cost_field.setEditable (false);
		
		guest_field.textProperty ().addListener ((observable, old_value, new_value) -> {
			calcCost (guest_field, cost_field);
		});
		
		Button save_button = new Button ("Save");
		save_button.setOnAction (event -> {
			try {
				save (name_field, phone_field, guest_field, entree_list, side_dish_list, dessert_list);
			} catch (IOException exception) {
				exception.printStackTrace ();
			}
		});
		
		mainPane.add (name_label, 2, 2);
		mainPane.add (name_field, 2, 3);
		
		mainPane.add (phone_label, 2, 4);
		mainPane.add (phone_field, 2, 5);
		
		mainPane.add (guests_label, 2, 6);
		mainPane.add (guest_field, 2, 7);
		
		mainPane.add (cost_label, 2, 8);
		mainPane.add (cost_field, 2, 9);
		
		mainPane.add (entree_label, 2, 10);
		for (int i  = 0; i < 4; ++i) {
			RadioButton radio = new RadioButton (entrees [i]);
			radio.setFont (font);
			entree_list.add (radio);
			
			radio.setToggleGroup (entree_group);
			mainPane.add (radio, i + 2, 11);
		}
		
		mainPane.add (side_dish_label, 2, 12);
		for (int i  = 0; i < 4; ++i) {
			CheckBox check = new CheckBox (side_dishes [i]);
			check.setFont (font);
			side_dish_list.add (check);
			
			mainPane.add (check, i + 2, 13);
			
			check.setOnAction (e -> checkValidation (side_dish_list));
		}
		
		mainPane.add (dessert_label, 2, 14);
		for (int i  = 0; i < 3; ++i) {
			RadioButton radio = new RadioButton (desserts [i]);
			radio.setFont (font);
			dessert_list.add (radio);
			
			radio.setToggleGroup (dessert_group);
			mainPane.add (radio, i + 2, 15);
		}
		
		mainPane.add (save_button, 2, 17);
				
		Scene catering_scene = new Scene (mainPane, 800, 700);
		
		primaryStage.setTitle ("Cindy's Catering");
		primaryStage.setScene (catering_scene);
		primaryStage.show ();
	}
	
	public static void main (String [] args) {
		launch (args);
	}
	
	public void save (TextField name_field, TextField phone_field, TextField guest_field, ArrayList <RadioButton> entree_list, ArrayList <CheckBox> side_list, ArrayList <RadioButton> dessert_list) throws IOException {
		String final_list = "";
		String event_file = "Event.txt";
		
		String name = name_field.getText ();
		String guest = guest_field.getText ();
		String phone = phone_field.getText ();
		String entree = getRadioSelect (entree_list);
		String sides = getCheckSelect (side_list);
		String dessert = getRadioSelect (dessert_list);
		
		final_list = name + "; " + guest + "; " + phone + "; " + entree + "; " + sides + "; " + dessert;
		System.out.println (final_list);
		
		File event_output = new File (event_file);
		PrintWriter event_writer = new PrintWriter (event_output);
		
		event_writer.println(final_list);
		
		event_writer.close ();
	}
	
	public void checkValidation (ArrayList <CheckBox> check_list) {
		int count = 0;
		
		for (CheckBox check : check_list) {
			if (check.isSelected ()) {
				++count;
			}
		}
		
		if (count > 2) {
			for (CheckBox check : check_list) {
				check.setSelected (false);
			}
		}
	}
	
	public void calcCost (TextField guest_field, TextField cost_field) {
		try {
			double amount = Math.ceil (Double.parseDouble (guest_field.getText () ));
			
			cost_field.setText ("$" + 35.0 * amount);
		} catch (Exception e) {
			cost_field.setText ("$" + 0);
		}
	}
	
	public String getRadioSelect (ArrayList <RadioButton> choices) {
		for (RadioButton choice : choices) {
			if (choice.isSelected ()) {
				return choice.getText ();
			}
		}
		
		return "None";
	}
	
	public String getCheckSelect (ArrayList <CheckBox> choices) {
		boolean selected = false;
		int count = 0;
		String final_selected = "";
		
		for (CheckBox choice : choices) {
			if (choice.isSelected ()) {
				selected = true;
				++count;
				
				if (count > 1) {
					final_selected += ", ";
				}
				
				final_selected += choice.getText ();
			}
		}
		
		return selected ? final_selected : "None";
	}
}

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class Controls extends Application {
	@Override
	public void start (Stage primaryStage) {
		GridPane mainPane = new GridPane ();
		
		mainPane.setAlignment (Pos.CENTER);
		mainPane.setHgap (10);
		mainPane.setVgap (20);
		
		Button btChoose = new Button ("Choose Pies");
		btChoose.setTextFill (Color.PURPLE);
		
		Font ckFont = Font.font ("Arial", FontWeight.BOLD, 16);
		
		TextField tfChoice = new TextField ("Chosen Pies: ");
		tfChoice.setPrefWidth (425);
		tfChoice.setFont (ckFont);
		
		CheckBox ckStrawberry = new CheckBox ("Strawberry Pie");
		ckStrawberry.setTextFill (Color.PINK);
		ckStrawberry.setFont (ckFont);
		
		CheckBox ckChocolate = new CheckBox ("Chocolate Pie");
		ckChocolate.setTextFill (Color.BROWN);
		ckChocolate.setFont (ckFont);
		
		CheckBox ckKeyLime = new CheckBox ("Key Lime Pie");
		ckKeyLime.setTextFill (Color.GREEN);
		ckKeyLime.setFont (ckFont);
		
		CheckBox ckPeach = new CheckBox ("Peach Pie");
		ckPeach.setTextFill (Color.ORANGE);
		ckPeach.setFont (ckFont);
		
		mainPane.add (btChoose, 0, 0);
		mainPane.add (ckStrawberry, 0, 1);
		mainPane.add (ckChocolate, 0, 2);
		mainPane.add (ckKeyLime, 0, 3);
		mainPane.add (ckPeach, 0, 4);
		mainPane.add (tfChoice, 0, 5);
		
		btChoose.setOnAction (e -> {
			String ckResult = "Pies Chosen are ";
			if (ckStrawberry.isSelected ())
				ckResult = ckResult + "Strawberry Pie ";
			if (ckChocolate.isSelected ())
				ckResult = ckResult + "Chocolate Pie ";
			if (ckKeyLime.isSelected ())
				ckResult = ckResult + "Key Lime Pie ";
			if (ckPeach.isSelected ())
				ckResult = ckResult + "Peach Pie ";
				
			tfChoice.setText (ckResult);
		});
		
		ComboBox <String> cbPrizes = new ComboBox <> ();
		cbPrizes.setEditable (false);
		cbPrizes.setPromptText ("Choose a Prize");
		cbPrizes.getItems ().addAll ("42 in TV", "iPhone 7", "HP Laptop", "HP Color Laser");
		cbPrizes.setVisibleRowCount (2);
		
		TextField tfPrize = new TextField ("Chosen Prize: ");
		tfPrize.setPrefWidth (200);
		tfPrize.setFont (ckFont);
		
		mainPane.add (cbPrizes, 4, 0);
		mainPane.add (tfPrize, 5, 4);
		
		cbPrizes.setOnAction (e -> {
			tfPrize.setText ("Chosen Prize: " + cbPrizes.getValue ());
		});
		
		RadioButton rbChilis = new RadioButton ("Chili's");
		rbChilis.setTextFill (Color.NAVY);
		rbChilis.setFont (ckFont);
		
		RadioButton rbFridays = new RadioButton ("Friday's");
		rbFridays.setTextFill (Color.MAGENTA);
		rbFridays.setFont (ckFont);
		
		RadioButton rbOCharleys = new RadioButton ("O'Charley's");
		rbOCharleys.setTextFill (Color.BLUE);
		rbOCharleys.setFont (ckFont);
		
		RadioButton rbTacoMac = new RadioButton ("Taco Mac");
		rbTacoMac.setTextFill (Color.CYAN);
		rbTacoMac.setFont (ckFont);
		
		ToggleGroup rbGroup = new ToggleGroup ();
		
		rbChilis.setToggleGroup (rbGroup);
		rbFridays.setToggleGroup (rbGroup);
		rbOCharleys.setToggleGroup (rbGroup);
		rbTacoMac.setToggleGroup (rbGroup);
		
		Button btFavorite = new Button ("Get Favorite");
		btFavorite.setTextFill (Color.BLUE);
		
		TextField tfRestaurant = new TextField ("Favorite Restaurant: ");
		tfRestaurant.setFont (ckFont);
		tfRestaurant.setPrefWidth (250);
		
		mainPane.add (btFavorite, 0, 8);
		mainPane.add (rbChilis, 1, 8);
		mainPane.add (rbFridays, 2, 8);
		mainPane.add (rbOCharleys, 3, 8);
		mainPane.add (rbTacoMac, 4, 8);
		mainPane.add (tfRestaurant, 5, 8);
		
		btFavorite.setOnAction (e -> {
			String rbResult;
			
			if (rbChilis.isSelected ())
				rbResult = "Chili's";
			else if (rbFridays.isSelected ())
				rbResult = "Friday's";
			else if (rbOCharleys.isSelected ())
				rbResult = "O'Charley's";
			else
				rbResult = "Taco Mac";
			
			tfRestaurant.setText ("Favorite Restaurant: " + rbResult);
		});
				
		Scene ckScene = new Scene (mainPane, 800, 300);
		
		primaryStage.setTitle ("Pies");
		primaryStage.setScene (ckScene);
		primaryStage.show ();
	}
	
	public static void main (String [] args) {
		launch (args);
	}			
}

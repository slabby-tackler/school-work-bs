import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

public class Investment extends Application {
	public static void main (String [] args) {
		launch (args);
	}
	
	@Override
	public void start (Stage primary_stage) {
		GridPane investment_pane = new GridPane ();
		investment_pane.setAlignment (Pos.CENTER);
		investment_pane.setVgap (10);
		investment_pane.setHgap (5);
		
		TextField amount_input = new TextField ();
		TextField rate_input = new TextField ();
		TextField months_input = new TextField ();
		TextField final_value_input = new TextField ();
		
		final_value_input.setEditable (false);
		
		amount_input.setAlignment (Pos.BOTTOM_RIGHT);
		rate_input.setAlignment (Pos.BOTTOM_RIGHT);
		months_input.setAlignment (Pos.BOTTOM_RIGHT);
		final_value_input.setAlignment (Pos.BOTTOM_RIGHT);
		
		Label amount_label = new Label ("Investment Amount");
		Label rate_label = new Label ("Monthly Interest Rate");
		Label months_label = new Label ("Number of Years");
		Label final_value_label = new Label ("Future Value");
		
		Button calculate_button = new Button ("Calculate");
		calculate_button.setTextFill (Color.PURPLE);
		
		investment_pane.add (amount_label, 0, 0);
		investment_pane.add (amount_input, 0, 1);
		
		investment_pane.add (rate_label, 0, 2);
		investment_pane.add (rate_input, 0, 3);
		
		investment_pane.add (months_label, 0, 4);
		investment_pane.add (months_input, 0, 5);
		
		investment_pane.add (final_value_label, 0, 6);
		investment_pane.add (final_value_input, 0, 7);
		
		investment_pane.add (calculate_button, 0, 8);
		
		calculate_button.setOnAction (e -> {
			double amount = Double.parseDouble (amount_input.getText());
			double rate = Double.parseDouble (rate_input.getText()) / 100;
			double months = Double.parseDouble (months_input.getText());
			
			double future_value = amount * Math.pow((1 + rate), (months * 12));
			
			final_value_input.setText (Double.toString (future_value));
		});
		
		Scene investment_scene = new Scene (investment_pane, 600, 400);
		
		primary_stage.setTitle ("Future Value");
		primary_stage.setScene (investment_scene);
		
		primary_stage.show ();
	}
}

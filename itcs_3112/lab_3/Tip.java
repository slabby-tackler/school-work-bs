import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;

public class Tip extends Application {
	@Override
	public void start (Stage primaryStage) {
		GridPane tipPane = new GridPane ();
		tipPane.setAlignment (Pos.CENTER);
		tipPane.setVgap (10);
		tipPane.setHgap (5);
		
		TextField tfCheck = new TextField ();
		TextField tfPercent = new TextField ();
		TextField tfTotal = new TextField ();
		
		tfTotal.setEditable (false);
		
		tfCheck.setAlignment (Pos.BOTTOM_RIGHT);
		tfPercent.setAlignment (Pos.BOTTOM_RIGHT);
		tfTotal.setAlignment (Pos.BOTTOM_RIGHT);
		
		Label lbCheck = new Label ("Check Amount");
		Label lbPercent = new Label ("Tip Percent");
		Label lbTotal = new Label ("Total Amount");
		
		Button btCalc = new Button ("Calculate");
		btCalc.setTextFill (Color.RED);
		
		tipPane.add (lbCheck, 0, 0);
		tipPane.add (tfCheck, 1, 0);
		
		tipPane.add (lbPercent, 0, 1);
		tipPane.add (tfPercent, 1, 1);
		
		tipPane.add (lbTotal, 0, 2);
		tipPane.add (tfTotal, 1, 2);
		
		tipPane.add (btCalc, 1, 4);
		
		btCalc.setOnAction (e -> {
			double check = Double.parseDouble (tfCheck.getText());
			double percent = Double.parseDouble (tfPercent.getText());
			
			percent = percent / 100;
			
			double total = check + (check * percent);
			
			tfTotal.setText (Double.toString (total));
		});
		
		Scene tipScene = new Scene (tipPane, 400, 300);
		
		primaryStage.setTitle ("Gratuity");
		primaryStage.setScene (tipScene);
		
		primaryStage.show ();
	}
	
	public static void main (String [] args) {
		launch (args);
	}
}

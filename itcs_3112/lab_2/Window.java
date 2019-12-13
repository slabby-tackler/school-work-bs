import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.geometry.Pos;

public class Window extends Application {
	@Override
	public void start (Stage primaryStage) {
		GridPane pane = new GridPane ();
		pane.setAlignment (Pos.CENTER);
		pane.setHgap (20);
		pane.setVgap (10);
		
		Circle circ = new Circle ();
		circ.setCenterX (100);
		circ.setCenterY (100);
		circ.setRadius (50);
		circ.setStroke (Color.BLUE);
		circ.setFill(Color.YELLOW);
		
		Label hello = new Label ("Hello World");
		hello.setFont (Font.font ("Courier New", FontWeight.BOLD, FontPosture.ITALIC, 20));
		
		Label fun = new Label ("Programming is Fun!!");
		fun.setFont (Font.font("Arial", FontWeight.BOLD, 40));
		
		pane.add (circ, 2, 2);
		pane.add (hello, 1, 0);
		pane.add (fun, 0, 0);
		
		Scene sceneCirc = new Scene (pane, 200, 200);
		primaryStage.setScene (sceneCirc);
		primaryStage.setTitle ("Circle");
		
		primaryStage.show ();
	}
	
	public static void main (String [] args) {
		launch (args);
	}
}

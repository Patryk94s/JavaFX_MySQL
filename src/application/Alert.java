package application;



import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Alert {
	
	
	
	public static void info(String wiad){
		
	
	Stage okno = new Stage();
	okno.setTitle("Informacja");
	okno.setMinWidth(250);
	okno.setMaxHeight(150);
	
	
	Label label = new Label();
	label.setText(wiad);
	Button button = new Button("PotwierdŸ");
	button.setOnAction(e -> okno.close());
	
	VBox grup = new VBox(2);
	
	grup.getChildren().addAll(label,button);
	grup.setAlignment(Pos.CENTER);
	
	Scene scene = new Scene(grup);
	okno.setScene(scene);
	okno.showAndWait();
	
	}
	

}

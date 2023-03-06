package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	private static Stage stg;
	@Override
	public void start(Stage primaryStage) {
		try {
			stg=primaryStage;
			primaryStage.setResizable(false);
			primaryStage.setTitle("coride_poste");
			BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void changeScene(String fxml) throws IOException {
		BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(root);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
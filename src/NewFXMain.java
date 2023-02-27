/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author MSI
 */
public class NewFXMain extends Application {
    
    /**
     *
      * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        
        
        
            
        GridPane coride = new GridPane();
        coride.setHgap(15);
        coride.setVgap(15);
            Parent coride = FXMLLoader.load(getClass().getResource("FXML.fxml"));
            
            Scene scene = new Scene(coride, 600, 250);
            
//            Label lblnom = new Label("username");
//            coride.add(lblnom, 0, 0);
//            TextField txtnom = new TextField();
//            coride.add(txtnom, 1, 0);
            
            primaryStage.setScene(scene);
            primaryStage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

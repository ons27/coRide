/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coride;

import entity.trajet;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import service.trajetservice;

/**
 *
 * @author MSI
 */
public class trajetController {
    ObservableList<String> combolist = FXCollections.observableArrayList("Simple","Composer");
    @FXML
    private TextField departNom;

    @FXML
    private TextField destinationNom;
    @FXML
    private ComboBox typechoice;    
    public void initialize() {
        typechoice.setValue("Type");
        typechoice.setItems(combolist);
        
    }

    @FXML
    private void Add(ActionEvent event) {
        try {
            if ((departNom.getText().isEmpty() || destinationNom.getText().isEmpty()) || typechoice.getSelectionModel().isEmpty()) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                
                alert.setTitle("Information Dialog");
                
                alert.setHeaderText("rien a afficher");
                
                alert.setContentText("Vide");
                
                alert.show();
            } else {
                trajet t = new trajet(departNom.getText(), destinationNom.getText(), (String) typechoice.getSelectionModel().getSelectedItem());
                trajetservice sc = new trajetservice();
                sc.insert(t);

                Alert alert = new Alert(AlertType.CONFIRMATION);

                alert.setTitle("Information Dialog");

                alert.setHeaderText("SUCCESS");

                alert.setContentText("Trajet insérée avec succés!");

                alert.showAndWait();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("liste.fxml"));
                Parent coride = (Parent) loader.load();

                Scene scene = new Scene(coride);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            }

        } catch (IOException ex) {
            Logger.getLogger(trajetController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void DisplayAll(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("liste.fxml"));
                Parent coride = (Parent) loader.load();

                Scene scene = new Scene(coride);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
      
    }

    

}

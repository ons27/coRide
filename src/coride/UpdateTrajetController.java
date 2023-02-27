/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package coride;

import entity.trajet;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.trajetservice;

/**
 * FXML Controller class
 *
 * @author chaima
 */
public class UpdateTrajetController implements Initializable {

    @FXML
    private TextField departNom;
    @FXML
    private TextField destinationNom;
    @FXML
    private ComboBox typechoice;

    ObservableList<String> combolist = FXCollections.observableArrayList("Simple", "Composer");

    private Stage stage;
    private Stage dialogStage;
    private trajet trajet;
    private boolean buttonConfirmerClicked ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typechoice.setValue("Choice Type");
        typechoice.setItems(combolist);
        // TODO
    }

    @FXML
    private void update(ActionEvent event) throws SQLException {

        trajetservice es = new trajetservice();

        trajet.setDepart(departNom.getText());
        trajet.setDestination(destinationNom.getText());
        trajet.setType(typechoice.getSelectionModel().getSelectedItem().toString());

        if ((departNom.getText().equals("")) || (destinationNom.getText().equals(""))) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur!!!");
            alert.setHeaderText("Champs manquants!!");
            alert.setContentText("Veuillez remplir tous les champs!");

            alert.showAndWait();
        } else {
            es.update(trajet);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("liste.fxml"));

            try {
                Parent root = loader.load();
                ListeController dc = loader.getController();
                departNom.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(UpdateTrajetController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setTrajet(trajet trajet) {
        this.trajet = trajet;
        this.departNom.setText(trajet.getDepart());
        this.destinationNom.setText(trajet.getDestination());
        this.typechoice.setValue(trajet.getType());

    }

    public TextField getDepartNom() {
        return departNom;
    }

    public void setDepartNom(TextField departNom) {
        this.departNom = departNom;
    }

    public TextField getDestinationNom() {
        return destinationNom;
    }

    public void setDestinationNom(TextField destinationNom) {
        this.destinationNom = destinationNom;
    }

    public ComboBox getTypechoice() {
        return typechoice;
    }

    public void setTypechoice(ComboBox typechoice) {
        this.typechoice = typechoice;
    }

}

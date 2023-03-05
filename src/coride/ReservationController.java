/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package coride;

import entity.trajet;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import service.trajetservice;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class ReservationController implements Initializable {
    trajetservice sc = new trajetservice();

    @FXML
    private TableView<trajet> tableviewtrajet;
    @FXML
    private TableColumn<?, ?> conducteur;
    @FXML
    private TableColumn<trajet, String> departColumn;
    @FXML
    private TableColumn<trajet, String> destinationColumn;
    @FXML
    private TableColumn<?, ?> typechoice;
    @FXML
    private TableColumn<trajet, Button> reserver;
    @FXML
    private TextField filterField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        List<trajet> trajet = sc.DisplayAll();
        ObservableList<trajet> olp = FXCollections.observableArrayList(trajet);
        tableviewtrajet.setItems(olp);
        departColumn.setCellValueFactory(new PropertyValueFactory("depart"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory("destination"));
         //recherche du trajet 

        FilteredList<trajet> filteredData = new FilteredList<>(olp, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {

            filteredData.setPredicate((t) -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String chercher = newValue.toLowerCase();

                if (t.getDepart().toLowerCase().contains(chercher)) {

                    return true;
                } else if (t.getDestination().toLowerCase().contains(chercher)) {

                    return true;
                } else {
                    return t.getType().toLowerCase().contains(chercher);
                }

            });
        });

        SortedList<trajet> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableviewtrajet.comparatorProperty());
        tableviewtrajet.setItems(sortedData);
    }    
    
}

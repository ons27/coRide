/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package coride;

import entity.trajet;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import service.trajetservice;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class ListeController implements Initializable {

    @FXML
    private TableView<trajet> tableviewtrajet;
    @FXML
    private TableColumn<trajet, String> departColumn;
    @FXML
    private TableColumn<trajet, String> destinationColumn;

    trajetservice sc = new trajetservice();

    @FXML
    private TableColumn<trajet, Button> deletes;
    @FXML
    private TableColumn<?, ?> typechoice;
    @FXML
    private TableColumn<trajet, Button> updates;
    @FXML
    private TextField filterField;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        List<trajet> trajet = sc.DisplayAll();
        ObservableList<trajet> olp = FXCollections.observableArrayList(trajet);
        tableviewtrajet.setItems(olp);
        departColumn.setCellValueFactory(new PropertyValueFactory("depart"));
        destinationColumn.setCellValueFactory(new PropertyValueFactory("destination"));
        typechoice.setCellValueFactory(new PropertyValueFactory("type"));
        this.delete();
        this.update();

        FilteredList<trajet> filteredData = new FilteredList<>(olp, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {

            filteredData.setPredicate((t) -> {
            

                if (newValue == null || newValue.isEmpty()){
                    return true;
                }

                String chercher = newValue.toLowerCase();

                if (t.getDepart().toLowerCase().contains(chercher)) {

                    return true;
                } else 
                    if (t.getDestination().toLowerCase().contains(chercher)) {

                    return true;
                } else 
                    if (t.getType().toLowerCase().contains(chercher)) {

                    return true;
                } else 
                    return false;
                
            });
        });

        SortedList<trajet> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableviewtrajet.comparatorProperty());
        tableviewtrajet.setItems(sortedData);
    }

    private void delete() {
        deletes.setCellFactory((param) -> {
            return new TableCell() {
                @Override
                protected void updateItem(Object item, boolean empty) {
                    setGraphic(null);
                    if (!empty) {
                        Button b = new Button("Supprimer");
                        b.setOnAction((event) -> {
                            try {

                                if (sc.supprimer(tableviewtrajet.getItems().get(getIndex()))) {
                                    System.out.println(tableviewtrajet.getItems().get(getIndex()));
                                    tableviewtrajet.getItems().remove(getIndex());
                                    tableviewtrajet.refresh();

                                }
                            } catch (SQLException ex) {
                                System.out.println("erreor:" + ex.getMessage());

                            }
                        });
                        setGraphic(b);

                    }
                }
            };

        });

    }

    private void update() {
        updates.setCellFactory((param) -> {
            return new TableCell() {
                @Override
                protected void updateItem(Object item, boolean empty) {
                    setGraphic(null);
                    if (!empty) {
//                        Image imageDecline = new Image(getClass().getResourceAsStream("deleteicon.png"));
//                        Image imageDecline = new Image(getClass().getResourceAsStream("coride_logo.png"));

                        Button u = new Button("Modifier");
//                        u.setGraphic(new ImageView(imageDecline));

                        u.setOnAction((event) -> {
                            trajet trajet = (trajet) tableviewtrajet.getSelectionModel().getSelectedItem();

//                              JOptionPane.showMessageDialog(null, evenement);
                            if (tableviewtrajet.getSelectionModel().getSelectedItem() != null) {
                                boolean buttonConfirmerClicked;
                                try {
                                    buttonConfirmerClicked = showGestionTrajetManipulation(trajet);
                                } catch (IOException ex) {
                                    Logger.getLogger(ListeController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                if (true) {

                                    List<trajet> listeTrajet = sc.DisplayAll();
                                    ObservableList<trajet> olp = FXCollections.observableArrayList(trajet);
                                    tableviewtrajet.setItems(olp);
                                    departColumn.setCellValueFactory(new PropertyValueFactory("depart"));
                                    destinationColumn.setCellValueFactory(new PropertyValueFactory("destination"));
                                    typechoice.setCellValueFactory(new PropertyValueFactory("type"));
                                }
                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setContentText("Selectionner un trajet");
                                alert.show();

                            }
                        });
                        setGraphic(u);

                    }
                }
            };

        });

    }

    public boolean showGestionTrajetManipulation(trajet trajet) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("UpdateTrajet.fxml"));
        AnchorPane page = (AnchorPane) fxmlLoader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Gestion trajet");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        UpdateTrajetController controller = fxmlLoader.getController();
        controller.setDialogStage(dialogStage);
        controller.setTrajet(trajet);

        dialogStage.showAndWait();

        return true;

    }
    
  

}

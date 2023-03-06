package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.System.Logger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import coride.DataSource;
import entity.Postes;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import services.PosteServices;


public class Historique implements Initializable{
	
	public Historique() {}
	
	  @FXML
	  private TableView<Postes> postes;
	  @FXML
	  private TableColumn<Postes,Integer> id;
	  @FXML
	  private TableColumn<Postes,Integer> trajet;
	  @FXML
	  private TableColumn<Postes,Integer> vehicule;
	  @FXML
	  private TableColumn<Postes,Float> prix;
	  @FXML
	  private TableColumn<Postes,String> depart;
	  @FXML
	  private TableColumn<Postes,String> arriver;
	  @FXML
	  private TableColumn<Postes,String> editCol;
	  @FXML
	  private TextField filter;
	  @FXML
	  private Button refreshTable;
	
	  PosteServices ps= new PosteServices();

	  //observalble list to store data
	  ObservableList<Postes> dataList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		ObservableList<Postes> list =  PosteServices.readAll();

		List<Postes> poste =  ps.readAll();
        ObservableList<Postes> olp = FXCollections.observableArrayList(poste);
        postes.setItems(olp);
		
		// TODO Auto-generated method stub
		id.setCellValueFactory(new PropertyValueFactory<Postes,Integer>("id"));
		trajet.setCellValueFactory(new PropertyValueFactory<Postes,Integer>("id_trajet"));
		vehicule.setCellValueFactory(new PropertyValueFactory<Postes,Integer>("id_vehicule"));
		prix.setCellValueFactory(new PropertyValueFactory<Postes,Float>("prix"));
		depart.setCellValueFactory(new PropertyValueFactory<Postes,String>("depart"));
		arriver.setCellValueFactory(new PropertyValueFactory<Postes,String>("arrive"));
		
		//add cell of button edit 
        Callback<TableColumn<Postes, String>, TableCell<Postes, String>> cellFoctory = (TableColumn<Postes, String> param) -> {
           // make cell containing buttons
           final TableCell<Postes, String> cell = new TableCell<Postes, String>() {
               @Override
        	   @FXML
               public void updateItem(String item, boolean empty) {
                   super.updateItem(item, empty);
                   if (empty) {
                       setGraphic(null);
                       setText(null);

                   } else {
                	   Button deleteIcon = new Button("supprimer");
                	   Button editIcon = new Button("modifier");

                       deleteIcon.setOnAction(new EventHandler<ActionEvent>() {
                    	   @Override
                    	   public void handle(ActionEvent event) {
                    	        Postes p = postes.getSelectionModel().getSelectedItem();
                    	        if (p == null) {
                    	            System.out.println("No item selected. Please select an item to delete.");
                    	            return;
                    	        }
                    	        try {
                    	            Connection conn = DataSource.getInstance().getCnx();
                    	            PreparedStatement stmt = conn.prepareStatement(
                    	                    "DELETE FROM poste WHERE id = ?");
                    	            stmt.setInt(1, p.getId());
                    	            stmt.executeUpdate();
                    	            postes.getItems().remove(p);
                    	    		search();
                    	        } catch (SQLException e) {
                    	            e.printStackTrace();
                    	        }
                    	    }
                    	});

                      editIcon.setOnAction(new EventHandler<ActionEvent>() {
                    	   @Override
                    	   public void handle(ActionEvent event) {
                    		   
                   	     Postes p = postes.getSelectionModel().getSelectedItem();
                   	  if (p == null) {
          	            System.out.println("No item selected. Please select an item to delete.");
          	            return;
          	        }
                   	     FXMLLoader loader = new FXMLLoader ();
                         loader.setLocation(getClass().getResource("/application/Edit.fxml"));
                         try {
							loader.load();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                         EditPoste PController = loader.getController();
                         //PController.setUpdate(true);
                         PController.setPoste(p,p.getId_trajet(),p.getId_vehicule(), p.getPrix(), p.getDepart(), p.getArrive());
                         Parent parent = loader.getRoot();
                         Stage stage = new Stage();
                         stage.setScene(new Scene(parent));
                         stage.initStyle(StageStyle.UTILITY);
                         stage.show();
                 		 search();
                         
                    	   }  });

                       HBox managebtn = new HBox(deleteIcon,editIcon);
                       managebtn.setStyle("-fx-alignment:center");
                       HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                       HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                       setGraphic(managebtn);

                       setText(null);

                   }
               }

           };

           return cell;
       };

        editCol.setCellFactory(cellFoctory);
		postes.setItems(list);
		search();


		
	}
/*	
	 @FXML
	    private void close(MouseEvent event) {
	        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
	        stage.close();
	    }
	    @FXML
	    private void getAddView(MouseEvent event) {
	        try {
	            Parent parent = FXMLLoader.load(getClass().getResource("/tableView/addStudent.fxml"));
	            Scene scene = new Scene(parent);
	            Stage stage = new Stage();
	            stage.setScene(scene);
	            stage.initStyle(StageStyle.UTILITY);
	            stage.show();
	        } catch (IOException ex) {
	           // Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	    }
*/
	    @FXML
	    void search() {
	    	id.setCellValueFactory(new PropertyValueFactory<Postes,Integer>("id"));
			trajet.setCellValueFactory(new PropertyValueFactory<Postes,Integer>("id_trajet"));
			vehicule.setCellValueFactory(new PropertyValueFactory<Postes,Integer>("id_vehicule"));
			prix.setCellValueFactory(new PropertyValueFactory<Postes,Float>("prix"));
			depart.setCellValueFactory(new PropertyValueFactory<Postes,String>("depart"));
			arriver.setCellValueFactory(new PropertyValueFactory<Postes,String>("arrive"));
			
			dataList = ps.readAll();
			postes.setItems(dataList);
			FilteredList<Postes> filteredData = new FilteredList<>(dataList, b -> true);
			filter.textProperty().addListener((observable, oldValue, newValue)->{
				filteredData.setPredicate(p -> {
					if(newValue == null || newValue.isEmpty()) {return true;}
					String lowerCaseFilter = newValue.toLowerCase();
					if(String.valueOf(p.getId_trajet()).indexOf(lowerCaseFilter)!=-1) {return true;}
					else if(String.valueOf(p.getId_user()).indexOf(lowerCaseFilter)!=-1) {return true;}
					else if(String.valueOf(p.getId_vehicule()).indexOf(lowerCaseFilter)!=-1) {return true;}
					else if(String.valueOf(p.getPrix()).indexOf(lowerCaseFilter)!=-1) {return true;}
					else if(String.valueOf(p.getDepart()).indexOf(lowerCaseFilter)!=-1) {return true;}
					else if(String.valueOf(p.getArrive()).indexOf(lowerCaseFilter)!=-1) {return true;}
					else return false;
				});	
			});
			SortedList<Postes> sortedData = new SortedList<>(filteredData);
			sortedData.comparatorProperty().bind(postes.comparatorProperty());
			postes.setItems(sortedData);

	    	
	    }

	    @FXML
	    private void refreshTable(ActionEvent e) throws IOException {
	        try {
	        	System.out.println("refreshhhhhhhh noooow");
	        	ObservableList<Postes> list =  PosteServices.readAll();

	    		List<Postes> poste =  ps.readAll();
	            ObservableList<Postes> olp = FXCollections.observableArrayList(poste);
	            postes.setItems(olp);
	            
	        } catch (Exception ex) {}
	        
	        
	        
	    }

}

package application;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import coride.DataSource;
import entity.Postes;
import javafx.beans.property.SimpleFloatProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.PosteServices;

public class EditPoste{
	
	@FXML
	private Button editbtn;
	@FXML
	private ChoiceBox<String> trajets;
	@FXML
	private ChoiceBox<String> vehicules;
	@FXML
	private TextField prix;
	@FXML
	private DatePicker depart;
	@FXML
	private DatePicker arrive;
	
	
	private Stage stage;
	private Stage dialogStage;
	private Postes pos;
	private boolean buttonConfirmerClicked;
    int Id;
    Connection connection = null;
    String query = null;

	
	ObservableList<String> trajetList = FXCollections.observableArrayList("01","02","03","05");
	ObservableList<String> vehiculeList = FXCollections.observableArrayList("11","22","33","55");

	Postes poste = new Postes();

	@FXML
	public void initialize() {
		trajets.setValue("01");
		trajets.setItems(trajetList);
		
		vehicules.setValue("11");
		vehicules.setItems(vehiculeList);
	}
	
 	@FXML
    private void update(ActionEvent event) throws SQLException {
 		int t = Integer.parseInt(trajets.getValue().toString());
 		int v = Integer.parseInt(vehicules.getValue().toString());
		float p = Float.parseFloat(prix.getText().toString());
		String d = depart.toString();
		String a = arrive.toString();
		
		PosteServices ps = new PosteServices();
		pos.setId_trajet(t);
		pos.setId_vehicule(v);
		pos.setPrix(p);
		pos.setDepart(d);
		pos.setArrive(a);
		
		ps.update(pos);		
	}
		
    public void setPoste(Postes po, int trajet, int vehicule, float px, String dep, String arr) {
    	pos=po;

    	trajets.setValue(trajets.getValue().toString());
    	vehicules.setValue(vehicules.getValue().toString());
    	prix.setText(Float.toString(px));
    	depart.setPromptText(dep);
    	arrive.setPromptText(arr);
    }
    
    public void setPoste(Postes po) {
    	int t = Integer.parseInt(trajets.getValue().toString());
    	int v = Integer.parseInt(vehicules.getValue().toString());
		float p = Float.parseFloat(prix.getText().toString());
		String d = depart.toString();
		String a = arrive.toString();
		
    	pos = po;

    	trajets.setValue(trajets.getValue().toString());
    	vehicules.setValue(vehicules.getValue().toString());
    	prix.setText(Float.toString(p));
    	depart.setPromptText(d);
    	arrive.setPromptText(a);
    }

    
}
package application;

import java.io.IOException;
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
import java.util.ResourceBundle;

import javafx.beans.property.SimpleFloatProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import services.PosteServices;

public class AddPoste {
	ObservableList<String> trajetList = FXCollections.observableArrayList("01","02","03","05");
	ObservableList<String> vehiculeList = FXCollections.observableArrayList("11","22","33","55");


	public AddPoste() {}
	
	@FXML
	private Button addbtn;
	@FXML
	private Button addbtn1;
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
	
   
	@FXML
	public void initialize() {
		trajets.setValue("01");
		trajets.setItems(trajetList);
		
		vehicules.setValue("11");
		vehicules.setItems(vehiculeList);
	}
	
	@FXML
	public void addact(ActionEvent e) throws IOException{

		    int t = Integer.parseInt(trajets.getValue().toString());
		    int v = Integer.parseInt(vehicules.getValue().toString());
			float p = Float.parseFloat(prix.getText().toString());
			String d = depart.getValue().toString();
			String a = arrive.getValue().toString();
			
		PosteServices posteServices = new PosteServices();
		posteServices.insert(3636,t,v,p,d,a);
	
		Main m = new Main();
		m.changeScene("Historique.fxml");
		

		}
	
	@FXML
	public void nextact(ActionEvent e) throws IOException {
		Main m = new Main();
		//m.changeScene("Historique.fxml");
		m.changeScene("poste.fxml");
	}


	

   


}

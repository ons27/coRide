package application;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;

import entity.Emoji;
import entity.Postes;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.*;
import services.PosteServices;

public class Comment implements Initializable{
	
	 @FXML
	 private TextArea commentField ;
	 @FXML
	 private Button emojiButton;
	 @FXML
	 private GridPane emojiGrid;
	 @FXML
	 private ListView<String> emojiListView;
	 @FXML
		private TextField trajet;
	 @FXML
		private TextField vehicule;
	 @FXML
		private TextField prix;
	 @FXML
		private TextField depart;
	 @FXML
		private TextField arrive;
	 @FXML
		private Button addCmt;
	 
		
	// Function to retrieve the emoji list from the Emoji-API
	public String[] retrieveEmojiList() {

	    try {
	        // Make a URL connection to the Emoji-API
	        URL url = new URL("https://emoji-api.com/emojis?access_key=bf21cc52736fa59901b489ee11d219f6919e58a5");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");

	        // Read the JSON response
	        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        String inputLine;
	        StringBuilder response = new StringBuilder();
	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	        }
	        in.close();

	        // Parse the JSON response and extract the emoji list
	        JSONArray jsonArray = new JSONArray(response.toString());
	        String[] emojiList = new String[jsonArray.length()];
	        for (int i = 0; i < jsonArray.length(); i++) {
	            JSONObject jsonObject = jsonArray.getJSONObject(i);
	            emojiList[i] = jsonObject.getString("character");
	        }
	        return emojiList;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	@FXML
	public void showEmojiList(ActionEvent event) throws IOException{
		
		System.out.println("clicked emoooo!");
		String[] emojiList = retrieveEmojiList();
		
		emojiListView.setCellFactory(param -> new ListCell<>() {
		    private final Label label = new Label();
		    {
		        label.setStyle("-fx-font-size: 2em; -fx-padding: 5px;");
		    }

		    @Override
		    protected void updateItem(String item, boolean empty) {
		        super.updateItem(item, empty);
		        if (empty || item == null) {
		            setGraphic(null);
		        } else {
		            label.setText(item);
		            label.setFont(Font.font("Segoe UI Emoji", FontWeight.NORMAL, FontPosture.REGULAR, 20));
		            setGraphic(label);
		        }
		    }
		});

	        // Create a ListView to display the emoji list
	        for (String emoji : emojiList) {
	            emojiListView.getItems().add(emoji);
	        }

	            // Show the emoji list in a new window
	            Stage emojiStage = new Stage();
	            VBox emojiBox = new VBox(emojiListView);
	            Scene emojiScene = new Scene(emojiBox, 300, 400);
	            emojiStage.setScene(emojiScene);
	            emojiStage.show();

	        // Add a listener to the ListView to update the textArea with the selected emoji
	        emojiListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
	        commentField.appendText(newValue);});
	       

	     
	    }  


	
	@FXML
	public void addCmt(ActionEvent e) throws IOException{

			String comment = commentField.getText().toString();
			
		PosteServices posteServices = new PosteServices();
		posteServices.addComment(353, comment);
	
		//Main m = new Main();
		//m.changeScene("Historique.fxml");
		
		}
	@FXML
	public void Reserver(ActionEvent e) throws IOException{}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}

	
		
	
	

}




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import API.EnvoyerEmail;
import API.SendSMS;
import Entities.MoyenTransport;
import Entities.StarRating;
import Interface.IMoyenTransportService;
import MyConnection.MyConnection;
import Service.MoyenTransportService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javax.mail.MessagingException;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author TECHN
 */
public class MoyenTransportFXMLController implements Initializable {

    @FXML
    private TableColumn<MoyenTransport, String> type;
    @FXML
    private TableColumn<MoyenTransport, Integer> nbplaces;
    @FXML
    private TableColumn<MoyenTransport, String> matricule;
    @FXML
    private TableColumn<MoyenTransport, String> marque;
    @FXML
    private TextArea idMoyen;
    @FXML
    private TextArea typeMoyen;
    @FXML
    private TextArea nbplacesMoyen;
    @FXML
    private TextArea matriculeMoyen;
    @FXML
    private TextArea marqueMoyen;
    @FXML
    private Button supprimerMoyen;
    @FXML
    private Button ajouterMoyen;
    @FXML
    private Button modifierMoyen;
    @FXML
    private TableColumn<MoyenTransport, String> id;
    @FXML
    private TableView<MoyenTransport> tableMoyen;

    Connection mc;
    PreparedStatement ste;
    ObservableList<MoyenTransport>moyenList;
    @FXML
    private Button pdfbtn;
    @FXML
    private TextArea search;
    @FXML
    private Button tribtn;
     public String to_nbplace(int i){
     return "le nombre de place est " +i;
     }       

    @FXML
    private void trisignal(MouseEvent event) {
             mc=MyConnection.getInstance().getCnx();
            moyenList = FXCollections.observableArrayList();
      
      try {
            String requete = "SELECT * FROM moyentransport m ORDER BY nb_place DESC";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete); 
            while(rs.next()){
                MoyenTransport m = new MoyenTransport();
                m.setId_moy(rs.getInt("id_moy"));
                m.setType(rs.getString("type"));
                m.setNb_place(rs.getInt("nb_place"));
                m.setMatricule(rs.getString("matricule"));
                m.setMarque(rs.getString("marque")); 
                
                moyenList.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
  id.setCellValueFactory(data -> new SimpleObjectProperty(data.getValue().getId_moy()));
  type.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getType())); 
  
  nbplaces.setCellValueFactory(data -> new SimpleObjectProperty(data.getValue().getNb_place()));
  nbplaces.setCellFactory(col -> new StarRatingCell());
  
  
  matricule.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMatricule()));
  marque.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMarque()));
  tableMoyen.setItems(moyenList);
  
    }
         

    
    
    
     class StarRatingCell extends TableCell<MoyenTransport, Integer> {  //pour mettre les etoiles au graphique
    @Override
    protected void updateItem(Integer item, boolean empty) {
        super.updateItem(item, empty);
        if (!empty) {
            StarRating starRating = new StarRating(item);
            setText(starRating.display());
        } else {
            setText(null);
        }
    }
}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       afficherMoyenTransports();
    }    

    @FXML
    private void pdfsignal(MouseEvent event) throws  FileNotFoundException, DocumentException, IOException, SQLException {
        String sql = "SELECT * FROM moyentransport";
       
    ste=mc.prepareStatement(sql);
    ResultSet rs=ste.executeQuery();

    Document doc = new Document();
    PdfWriter.getInstance(doc, new FileOutputStream("./ListeDesMoyens.pdf"));

    doc.open();
   
    doc.add(new Paragraph("   "));
    doc.add(new Paragraph(" ************************************* Liste Des Moyens ************************************* "));
    doc.add(new Paragraph("   "));

    PdfPTable table = new PdfPTable(4);
    table.setWidthPercentage(125);
    PdfPCell cell;

    cell = new PdfPCell(new Phrase("TYPE", FontFactory.getFont("Comic Sans MS", 14)));
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    
    table.addCell(cell);
   
    cell = new PdfPCell(new Phrase("Nbr_Place", FontFactory.getFont("Comic Sans MS", 14)));
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    
    table.addCell(cell);
    
    cell = new PdfPCell(new Phrase("Matricule", FontFactory.getFont("Comic Sans MS", 14)));
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    
    table.addCell(cell);
    
     cell = new PdfPCell(new Phrase("Marque", FontFactory.getFont("Comic Sans MS", 14)));
    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
    
    table.addCell(cell);
    
    
  
    while (rs.next()) {

        MoyenTransport e = new MoyenTransport();
      
        e.setType(rs.getString("type"));
        e.setNb_place(rs.getInt("nb_place"));
       e.setMatricule(rs.getString("matricule"));
       e.setMarque(rs.getString("marque"));
     
      
        cell = new PdfPCell(new Phrase(e.getType(), FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase((to_nbplace(e.getNb_place())), FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        
        cell = new PdfPCell(new Phrase(e.getMatricule(), FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        
        
        cell = new PdfPCell(new Phrase(e.getMarque(), FontFactory.getFont("Comic Sans MS", 12)));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        
      
        
        table.addCell(cell);
    }

    doc.add(table);
    doc.close();
    Desktop.getDesktop().open(new File("./ListeDesMoyens.pdf"));
    }
    
    
    
    
    
    
      void afficherMoyenTransports(){
            mc=MyConnection.getInstance().getCnx();
            moyenList = FXCollections.observableArrayList();
      
      try {
            String requete = "SELECT * FROM moyentransport m ";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete); 
            while(rs.next()){
                MoyenTransport m = new MoyenTransport();
                m.setId_moy(rs.getInt("id_moy"));
                m.setType(rs.getString("type"));
                m.setNb_place(rs.getInt("nb_place"));
                m.setMatricule(rs.getString("matricule"));
                m.setMarque(rs.getString("marque")); 
                
                moyenList.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
  id.setCellValueFactory(data -> new SimpleObjectProperty(data.getValue().getId_moy()));
  type.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getType())); 
  
  nbplaces.setCellValueFactory(data -> new SimpleObjectProperty(data.getValue().getNb_place()));
  nbplaces.setCellFactory(col -> new StarRatingCell());
  
  
  matricule.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMatricule()));
  marque.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getMarque()));
  tableMoyen.setItems(moyenList);
  
  refresh();
  search();
  
  }
   
    public void refresh(){
            moyenList.clear();
            mc=MyConnection.getInstance().getCnx();
            moyenList = FXCollections.observableArrayList();
      
      try {
            String requete = "SELECT * FROM moyentransport m ";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs =  st.executeQuery(requete); 
            while(rs.next()){
                MoyenTransport m = new MoyenTransport();
                
                m.setId_moy(rs.getInt("id_moy"));
                m.setType(rs.getString("type"));
                m.setNb_place(rs.getInt("nb_place"));
                m.setMatricule(rs.getString("matricule"));
                m.setMarque(rs.getString("marque")); 
               
                
                moyenList.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        tableMoyen.setItems(moyenList);
        search();
        
  }
      
      
      
      
      
      
      
      
      
   
    
    
    @FXML
    private void selected(MouseEvent event) {
        MoyenTransport clicked = tableMoyen.getSelectionModel().getSelectedItem();
        idMoyen.setText(String.valueOf(clicked.getId_moy()));
        typeMoyen.setText(String.valueOf(clicked.getType()));
        nbplacesMoyen.setText(String.valueOf(clicked.getNb_place()));
        matriculeMoyen.setText(String.valueOf(clicked.getMatricule()));
        marqueMoyen.setText(String.valueOf(clicked.getMarque()));
    }

    
    
    @FXML
    private void deleteMoyen(MouseEvent event) {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setHeaderText("Warning");
       alert.setContentText("Es-tu sûre de supprimer!");

        String Value1 = idMoyen.getText();
        String type =typeMoyen.getText();
        String nbplaces =nbplacesMoyen.getText();
        String matricule =matriculeMoyen.getText();
        String marque =marqueMoyen.getText();
        
        
        Optional<ButtonType>result =  alert.showAndWait();
        if(result.get() == ButtonType.OK)
        {
      
         MoyenTransport m= new MoyenTransport(Integer.parseInt(Value1),type,Integer.parseInt(nbplaces),matricule,marque);
        IMoyenTransportService ms= new MoyenTransportService();
        ms.supprimerMoyenTransport(m);
        refresh();
      
      
        idMoyen.setText(null);
        typeMoyen.setText(null);
        nbplacesMoyen.setText(null);
        matriculeMoyen.setText(null);
        marqueMoyen.setText(null);
            
        }  
        
    }

    @FXML
    private void addMoyen(MouseEvent event) throws MessagingException {
   
        
        String type =typeMoyen.getText();
        String nbplaces =nbplacesMoyen.getText();
        String matricule =matriculeMoyen.getText();
        String marque=marqueMoyen.getText();
        
          if (type.isEmpty() || nbplaces.isEmpty()|| matricule.isEmpty()|| marque.isEmpty()){ 
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
             alert.setContentText("Il y a un champ vide !!"); // controle de saisie vide
             alert.showAndWait();      
             Notifications.create().title("Error").text("Champ Vide").showError();
         }
        
      
          else{
        MoyenTransport m= new MoyenTransport(type,Integer.parseInt(nbplaces),matricule,marque);
        
        IMoyenTransportService ms= new MoyenTransportService();
        ms.ajouterMoyenTransport(m);//appel de la fonction ajouter        
       
        Notifications.create().title("Success").text("Le moyen est ajouté avec succes").showInformation();//notificaation
        
        //SendSMS sm = new SendSMS();
       // sm.sendSMS();
        
        
        
       // String destinataire = "medamine.kbaier@esprit.tn";
       //int code = new Random().nextInt( 999999);
      // EnvoyerEmail.envoyer(destinataire, code);
        
        
        
        typeMoyen.setText(null);
        nbplacesMoyen.setText(null);           //yrodlik les text area vide baad AJOUT
        matriculeMoyen.setText(null);
        marqueMoyen.setText(null);
        
        
        refresh();
          }
    }

    @FXML
    private void updateMoyen(MouseEvent event) {
        
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setHeaderText("Warning");
       alert.setContentText("Es-tu sûre de modifier!");

        String Value1 = idMoyen.getText();
        String type =typeMoyen.getText();
        String nbplaces =nbplacesMoyen.getText();
        String matricule =matriculeMoyen.getText();
        String marque =marqueMoyen.getText();
        
        
        Optional<ButtonType>result =  alert.showAndWait();
        if(result.get() == ButtonType.OK)
        {
      
         MoyenTransport m= new MoyenTransport(Integer.parseInt(Value1),type,Integer.parseInt(nbplaces),matricule,marque);
        IMoyenTransportService ms= new MoyenTransportService();
        ms.modifierMoyenTransport(m);
        refresh();
      
      
        idMoyen.setText(null);
        typeMoyen.setText(null);
        nbplacesMoyen.setText(null);
        matriculeMoyen.setText(null);
        marqueMoyen.setText(null);
            
        } } 
        
        private void search() {      
        FilteredList<MoyenTransport>filteredData = new FilteredList<>(moyenList, b->true);
        search.textProperty().addListener((observable, oldValue, newValue)->{
            filteredData.setPredicate(MoyenTransport -> {
    if (newValue == null || newValue.isEmpty()) {
        return true;
    }
    String lowerCaseFilter = newValue.toLowerCase();
    if (MoyenTransport.getMarque().toLowerCase().contains(lowerCaseFilter)) {
        return true;
    } else if (MoyenTransport.getType().toString().contains(lowerCaseFilter)) {
        return true;
    } else {
        return false;
    }
});        
        });
        SortedList<MoyenTransport>sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tableMoyen.comparatorProperty());
        
        tableMoyen.setItems(sortedData);
    }
        
        
        
    }
    


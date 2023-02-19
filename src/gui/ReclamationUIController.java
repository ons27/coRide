/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.corba.se.spi.orb.ParserImplBase;
import entities.Alerte;
import entities.Reclamation;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import services.AlerteService;
import services.ReclamationService;

/**
 * FXML Controller class
 *
 * @author Ons Bouhjar
 */
public class ReclamationUIController implements Initializable {

    @FXML
    private TextField TF_Sujet;
    @FXML
    private Button bouton_ajouter;
    @FXML
    private TextField TF_idemploye;
    @FXML
    private TextArea PT_text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void On_ajouter_clicked(ActionEvent event) {
        try {
            Reclamation r = new Reclamation(TF_Sujet.getText(), PT_text.getText(), Integer.parseInt(TF_idemploye.getText()), 1);
            ReclamationService rs = new ReclamationService();
            rs.ajouter(r);
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationUIController.class.getName()).log(Level.SEVERE, null, ex);
        }

        Alerte A = new Alerte();

        AlerteService as = new AlerteService();
        A = as.GetAlerteByIdEmploye(1);
        if (A.getId() == 0) {
            Alerte newA = new Alerte(1, "premiere alerte", 0, 1);
            try {
                as.ajouter(newA);
            } catch (SQLException ex) {
                Logger.getLogger(ReclamationUIController.class.getName()).log(Level.SEVERE, null, ex);

            }
        } else {
            switch (A.getNombreReclamation()) {
                case 1: {
                    A.setMessage("Deuxieme Alerte");
                    A.setNombreReclamation(2);
                    try {
                        as.modifier(A);
                    } catch (SQLException ex) {
                        Logger.getLogger(ReclamationUIController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;
                case 2: {
                         A.setMessage("Troisieme Alerte");
                    A.setNombreReclamation(3);
                    try {
                        as.modifier(A);
                    } catch (SQLException ex) {
                        Logger.getLogger(ReclamationUIController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case 3: {
                        A.setMessage("Alerte finale , Votre compte sera suspendu dans une semaine !");
                    A.setNombreReclamation(4);
                    A.setEtat(1);
                    
                    try {
                        as.modifier(A);
                    } catch (SQLException ex) {
                        Logger.getLogger(ReclamationUIController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

            }

        }

    }

}

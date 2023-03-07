/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kbayer;

import API.EnvoyerEmail;
import API.SendSMS;
import Entities.MoyenTransport;
import MyConnection.MyConnection;
import Service.MoyenTransportService;
import Interface.IMoyenTransportService;
import java.util.Random;
import javax.mail.MessagingException;
/**
 *
 * @author TECHN
 */
public class Kbayer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MessagingException {
       MyConnection mc = MyConnection.getInstance();
        System.out.println(mc.hashCode());
        
        
        
        MoyenTransport m = new MoyenTransport(2,"PASSAT",1,"GGGG","POLOPO");
       
        IMoyenTransportService ms = new MoyenTransportService();
        //ms.ajouterMoyenTransport(m);
        //ms.supprimerMoyenTransport(m);
        //ms.modifierMoyenTransport(m);
        //ms.afficherMoyenTransports();
        
     
       // String destinataire = "medamine.kbaier@esprit.tn";
     //  int code = new Random().nextInt( 999999);
      // EnvoyerEmail.envoyer(destinataire, code);
        
       // SendSMS sm = new SendSMS();
      // sm.sendSMS();
    }
    
}

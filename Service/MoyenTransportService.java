/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Interface.IMoyenTransportService;
import Entities.MoyenTransport;
import MyConnection.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TECHN
 */
public class MoyenTransportService implements IMoyenTransportService<MoyenTransport>{
    
    
    @Override
    public void ajouterMoyenTransport(MoyenTransport m) {
        
        try {
            String requete= "INSERT INTO moyentransport (type,nb_place,matricule,marque)"
                    + "VALUES (?,?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            
            pst.setString(1, m.getType());
            pst.setInt(2, m.getNb_place());
            pst.setString(3,m.getMatricule());
            pst.setString(4,m.getMarque());
           
            
            pst.executeUpdate();
            System.out.println("MoyenTransport ajoutée");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    



   
    @Override
    public void supprimerMoyenTransport(MoyenTransport m) {
        try {
            String requete = "DELETE FROM moyentransport where id_moy=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, m.getId_moy());
            pst.executeUpdate();
            System.out.println("Moyen Transport supprimée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @param m
     */
    @Override
    public void modifierMoyenTransport(MoyenTransport m) {
        try {
            String requete = "UPDATE moyentransport SET type=?,nb_place=?,matricule=?,marque=? WHERE id_moy=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1, m.getType());
            pst.setInt(2, m.getNb_place());
            pst.setString(3, m.getMatricule());
            pst.setString(4,m.getMarque());
            pst.setInt(5,m.getId_moy());
            
            pst.executeUpdate();
            System.out.println("Moyen Transport modifiée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    } 

    /**
     *
     * @return
     */
    @Override
  public List<MoyenTransport> afficherMoyenTransports() {        
         List<MoyenTransport> MoyenTransportsList = new ArrayList<>();
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
                System.out.println("the added moyens :" +m.toString());
                MoyenTransportsList.add(m);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return MoyenTransportsList;
     
     
     
     }
    
}

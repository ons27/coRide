/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import connexionbd.util.DataSource;
import entity.trajet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MSI
 */
public class trajetservice implements IService<trajet>{
    
     Connection con;
    public trajetservice(){
        con = DataSource.getInstance().getCnx();
    }
    @Override
    public void insert(trajet t){
        
       
        try {
            String reqt="INSERT INTO trajet (id_trajet ,depart, destination,nb_place, prix) values"+"('"+t.getId_trajet()+"','"+t.getDepart()+"','"+t.getDestination()+"','"+t.getNb_place()+"','"+t.getPrix()+"')";
            System.out.println("trajet ajouté");
            Statement ste=con.createStatement();
            ste.executeUpdate(reqt);
        } catch (SQLException ex) {
            Logger.getLogger(trajetservice.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
     @Override
    public void delete (trajet t){
         try {
             String req= "Delete From trajet where id_trajet="+t.getId_trajet();
             System.out.println("trajet supprimer");
             Statement ste=con.createStatement();
             ste.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(trajetservice.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
   
     @Override
    public void update (trajet t){
         try {
             String req= "update trajet set nb_place='5'where id_trajet= 1";
             System.out.println("trajet est modifier");
             Statement ste=con.createStatement();
             ste.executeUpdate(req);
         } catch (SQLException ex) {
             Logger.getLogger(trajetservice.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    /**
     *
     * @return
     */
    public List<trajet> DisplayAll() {
		// TODO Auto-generated method stub
		List<trajet> listeTrajet = new ArrayList<>();

		String requete = "select * from experience";
		try {
			Statement statement = con.createStatement();
			ResultSet resultat = statement.executeQuery(requete);

			while (resultat.next()) {
				trajet t = new trajet("");
				t.setId_trajet(resultat.getInt(1));
				t.setDepart(resultat.getNString(2));
				t.setDestination(resultat.getNString(3));
				t.setNb_place(resultat.getInt(1));
				t.setPrix(resultat.getFloat(2));
				listeTrajet.add(t);
			}
			return listeTrajet;
		} catch (SQLException ex) {
			// Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("erreur lors du chargement des experiences " + ex.getMessage());
			return null;
		}
	
    
}
}

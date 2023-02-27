/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import connexionBD.DataSource;
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
            String reqt="INSERT INTO trajet (depart, destination, type) values"+"('"+t.getDepart()+"','"+t.getDestination()+"','"+t.getType()+"')";
            System.out.println("trajet ajouté");
            Statement ste=con.createStatement();
            ste.executeUpdate(reqt);
        } catch (SQLException ex) {
            Logger.getLogger(trajetservice.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    
    @Override
    public boolean  supprimer(trajet t) throws SQLException {
    boolean ok = false;
        try {
            PreparedStatement req = con.prepareStatement("delete from trajet where id_trajet = ? ");
            req.setInt(1, t.getId_trajet());
            req.executeUpdate();
            ok = true;
        } catch (SQLException ex) {
            System.out.println("error in delete " + ex);
        }
        return ok;  
    }
   
     @Override
    public boolean update (trajet t)throws SQLException {
            boolean ok = false;

         try {
                String req= "UPDATE trajet SET depart='"+t.getDepart()+"',destination='"+t.getDestination()+"',type='"+t.getType()+"' WHERE id_trajet='"+t.getId_trajet()+"'";
                PreparedStatement ste = con.prepareStatement(req);
             ste.executeUpdate(req);
                          System.out.println("trajet est modifier");

                         ok = true;

         } catch (SQLException ex) {
             Logger.getLogger(trajetservice.class.getName()).log(Level.SEVERE, null, ex);
         }
         return ok;
    }

    /**
     *
     * @return
     */
     @Override
    public List<trajet> DisplayAll() {
		// TODO Auto-generated method stub
		List<trajet> listeTrajet = new ArrayList<>();

		String requete = "SELECT * FROM trajet";
		try {
			Statement statement = con.createStatement();
			ResultSet resultat = statement.executeQuery(requete);

			while (resultat.next()) {
				trajet t = new trajet(
				resultat.getInt(1),
				resultat.getString(2),
				resultat.getString(3),
				resultat.getString(4));
				
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

   
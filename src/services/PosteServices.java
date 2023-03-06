package services;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import application.Historique;
import coride.DataSource;
import entity.Postes;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PosteServices{

    private Connection conn;

    public PosteServices() {
        conn=DataSource.getInstance().getCnx();
    }
	
	public void insert(int u,int t,int v, float p, String d, String a) {
		// TODO Auto-generated method stub
		 String requete="insert into poste (id_user, id_trajet, id_vehicule, prix, depart, arrive) values (?,?,?,?,?,?)";
	        try {
	            PreparedStatement pst=conn.prepareStatement(requete);
	            pst.setInt  (1, u);
	            pst.setInt  (2, t);
	            pst.setInt  (3, v);
	            pst.setFloat(4, p);
	            pst.setString (5,d);
	            pst.setString (6,a);
	            pst.executeUpdate();
             System.out.println("poste ajouté");
	        } catch (SQLException ex) {
	            Logger.getLogger(PosteServices.class.getName()).log(Level.SEVERE, null, ex);
	        }
	}

	public static ObservableList<Postes> readAll() {
		ObservableList<Postes> resultats = FXCollections.observableArrayList();
		
		try {
	        Connection conn=DataSource.getInstance().getCnx();
			PreparedStatement ps = conn.prepareStatement("select * from poste");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				resultats.add(new Postes (rs.getInt("id"),rs.getInt("id_user"),rs.getInt("id_trajet"),rs.getInt("id_vehicule"), rs.getFloat("prix"), rs.getString("depart"), rs.getString("arrive")));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    return resultats;
	  }

	public boolean update(Postes p) throws SQLException {
		boolean ok=false;

	         try {
	                String req= "UPDATE poste SET id_trajet='"+p.getId_trajet()+"',id_trajet='"+p.getId_trajet()+"',id_vehicule='"+p.getId_vehicule()+"',prix='"+p.getPrix()+"' WHERE id='"+p.getId()+"'";

	                //String req= "UPDATE poste SET id_trajet='"+p.getId_trajet()+"',prix='"+p.getPrix()+"'depart='"+p.getDepart()+"',arrive='"+p.getArrive()+"' WHERE id='"+p.getId()+"'";
	                PreparedStatement ste = conn.prepareStatement(req);
	                ste.executeUpdate(req);
	                System.out.println("poste est modifier");
	                ok=true;

	         } catch (SQLException ex) {
	             Logger.getLogger(PosteServices.class.getName()).log(Level.SEVERE, null, ex);
	         }
	         return ok;
	    }		
	
	public void addComment(int user, String cmt) {
		// TODO Auto-generated method stub
		 String requete="insert into commentaire (id_user, text) values (?,?)";
	        try {
	            PreparedStatement pst=conn.prepareStatement(requete);
	            pst.setInt  (1, user);
	            pst.setString (2,cmt);
	            pst.executeUpdate();
             System.out.println("commentaire ajouté");
	        } catch (SQLException ex) {
	            Logger.getLogger(PosteServices.class.getName()).log(Level.SEVERE, null, ex);
	        }
	}

	
	/*public void delete(Postes p) {
		// TODO Auto-generated method stub
		   String requete="delete from postes where id = "+p.getId();
	        try {
	            Statement st=conn.createStatement();
	            st.executeUpdate(requete);
	        } catch (SQLException ex) {
	            Logger.getLogger(PosteServices.class.getName()).log(Level.SEVERE, null, ex);
	        }

	}
*/


/*
	@Override
	public Postes readById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	

	
}

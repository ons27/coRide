/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reclamation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author hp
 */
public class ReclamationService implements IService<Reclamation> {

    Connection cnx;

    public ReclamationService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Reclamation t) throws SQLException {

        /* PreparedStatement stmt = cnx.prepareStatement("INSERT INTO reclamation (text_rec) VALUES (?)");
       
       stmt.setString(1, t.getText_rec());
        Statement st = cnx.createStatement();
        stmt.executeUpdate();
         */
        String req = "INSERT INTO reclamation (text_rec,sujet,id_employe,id_user) VALUES("
                + "'" + t.getText_rec() + "','" + t.getSujet() + "','" + t.getId_employe() + "','" + t.getId_user() + "'" + ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);

    }

    @Override
    public void modifier(Reclamation t) throws SQLException {
        String req = "UPDATE reclamation SET text_rec = ?,sujet = ? , id_employe = ? where id_reclamation = ?";
        PreparedStatement vs = cnx.prepareStatement(req);
        vs.setString(1, t.getText_rec());
        vs.setString(2, t.getSujet());
        vs.setInt(3, t.getId_employe());
        vs.setInt(4, t.getId_rec());
        vs.executeUpdate();

    }

    @Override
    public void supprimer(Reclamation t) throws SQLException {
        String req = " DELETE FROM reclamation where id_reclamation = ?   ";

        PreparedStatement vs = cnx.prepareStatement(req);
        vs.setInt(1, t.getId_rec());
        vs.executeUpdate();
    }

    @Override
    public List<Reclamation> recuperer(Reclamation t) throws SQLException {
        List<Reclamation> Reclamation = new ArrayList<>();
        String s = "select * from reclamation ";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            Reclamation R = new Reclamation();

            R.setId_rec(rs.getInt("id_reclamation"));
            R.setSujet(rs.getString("sujet"));
            R.setText_rec(rs.getString("text_rec"));
            R.setId_employe(rs.getInt("id_employe"));
            R.setId_user(rs.getInt("id_user"));

            Reclamation.add(R);

        }
        return Reclamation;
    }
}

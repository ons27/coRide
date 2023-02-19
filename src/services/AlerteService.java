/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Alerte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author Ons Bouhjar
 */
public class AlerteService implements IService<Alerte> {

    Connection cnx;

    public AlerteService() {
        cnx = MyDB.getInstance().getCnx();
    }

    @Override
    public void ajouter(Alerte t) throws SQLException {
        String req = "INSERT INTO alerte (nbr,message,etat,id_employe) VALUES("
                + "'" + t.getNombreReclamation() + "','" + t.getMessage() + "','" + t.getEtat() + "','" + t.getId_employe() + "'" + ")";
        Statement st = cnx.createStatement();
        st.executeUpdate(req);

    }

    @Override
    public void modifier(Alerte t) throws SQLException {
        String req = "UPDATE alerte SET nbr = ?,message = ? , etat = ? , id_employe = ? where id_alerte = ?";
        PreparedStatement vs = cnx.prepareStatement(req);
        vs.setInt(1, t.getNombreReclamation());
        vs.setString(2, t.getMessage());
        vs.setInt(3, t.getEtat());
        vs.setInt(4, t.getId_employe());
        vs.setInt(5, t.getId());
        vs.executeUpdate();
    }

    @Override
    public void supprimer(Alerte t) throws SQLException {
        String req = " DELETE FROM alerte where id_alerte = ?   ";
        PreparedStatement vs = cnx.prepareStatement(req);
        vs.setInt(1, t.getId());
        vs.executeUpdate();
    }

    @Override
    public List<Alerte> recuperer(Alerte t) throws SQLException {
        List<Alerte> AlerteList = new ArrayList<>();
        String s = "select * from alerte ";
        Statement st = cnx.createStatement();
        ResultSet rs = st.executeQuery(s);
        while (rs.next()) {
            Alerte A = new Alerte();

            A.setId(rs.getInt("id_alerte"));
            A.setNombreReclamation(rs.getInt("nbr"));
            A.setMessage(rs.getString("message"));
            A.setEtat(rs.getInt("etat"));
            A.setId_employe(rs.getInt("id_employe"));

            AlerteList.add(A);

        }
        return AlerteList;
    }

    public Alerte GetAlerteByIdEmploye(int id_employe) {
        Alerte A = new Alerte();
        try {
            String s = "select * from alerte where id_employe = '" + id_employe + "' ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(s);
            while (rs.next()) {
                A.setId(rs.getInt("id_alerte"));
                A.setNombreReclamation(rs.getInt("nbr"));
                A.setMessage(rs.getString("message"));
                A.setEtat(rs.getInt("etat"));
                A.setId_employe(rs.getInt("id_employe"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(AlerteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return A;

    }

}

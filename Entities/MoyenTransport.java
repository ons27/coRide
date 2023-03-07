/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author TECHN
 */
public class MoyenTransport {
            private int id_moy;
            private String type;
            private int nb_place;
            private String matricule;
            private String marque;

    public MoyenTransport() {
    }

    public MoyenTransport(int id_moy, String type, int nb_place, String matricule, String marque) {
        this.id_moy = id_moy;
        this.type = type;
        this.nb_place = nb_place;
        this.matricule = matricule;
        this.marque = marque;
    }

    public MoyenTransport(String type, int nb_place, String matricule, String marque) {
        this.type = type;
        this.nb_place = nb_place;
        this.matricule = matricule;
        this.marque = marque;
    }
    
    
    

    public int getId_moy() {
        return id_moy;
    }

    public void setId_moy(int id_moy) {
        this.id_moy = id_moy;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "MoyenTransport{" + "id_moy=" + id_moy + ", type=" + type + ", nb_place=" + nb_place + ", matricule=" + matricule + ", marque=" + marque + '}';
    }
            
            
            
       
            
    
}

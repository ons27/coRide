/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author hp
 */
public class Reclamation {
    private 
            int id_rec;
            String sujet,text_rec;
            int id_user , id_employe ; 

    public Reclamation() {
    }

    public Reclamation(int id_rec, String sujet, String text_rec, int id_user, int id_employe) {
        this.id_rec = id_rec;
        this.sujet = sujet;
        this.text_rec = text_rec;
        this.id_user = id_user;
        this.id_employe = id_employe;
    }

    public Reclamation(String sujet, String text_rec, int id_user, int id_employe) {
        this.sujet = sujet;
        this.text_rec = text_rec;
        this.id_user = id_user;
        this.id_employe = id_employe;
    }

    public int getId_rec() {
        return id_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getText_rec() {
        return text_rec;
    }

    public void setText_rec(String text_rec) {
        this.text_rec = text_rec;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "sujet=" + sujet + ", text_rec=" + text_rec + ", id_user=" + id_user + ", id_employe=" + id_employe + '}';
    }
    

    

    
    
}

    
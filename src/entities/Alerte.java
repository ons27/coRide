/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Ons Bouhjar
 */
public class Alerte {
    
    
    private int id ;
    private int NombreReclamation ;
    private String message ; 
    private int etat ; 
    private int id_employe;

    public Alerte() {
    }
    
    public Alerte(int id, int NombreReclamation, String message, int etat, int id_employe) {
        this.id = id;
        this.NombreReclamation = NombreReclamation;
        this.message = message;
        this.etat = etat;
        this.id_employe = id_employe;
    }

    public Alerte(int NombreReclamation, String message, int etat, int id_employe) {
        this.NombreReclamation = NombreReclamation;
        this.message = message;
        this.etat = etat;
        this.id_employe = id_employe;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNombreReclamation() {
        return NombreReclamation;
    }

    public void setNombreReclamation(int NombreReclamation) {
        this.NombreReclamation = NombreReclamation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getId_employe() {
        return id_employe;
    }

    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }

    @Override
    public String toString() {
        return "Alerte{" + "NombreReclamation=" + NombreReclamation + ", message=" + message + ", etat=" + etat + ", id_employe=" + id_employe + '}';
    }
    

    
    
    
    
}

package entity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MSI
 */
public class trajet {
    
    private int id_trajet;
    private String depart;
    private String destination;
    private int nb_place;
    private float prix;
    
    

    public trajet(int id_trajet, String depart, String destination, int nb_place, float prix) {
        this.id_trajet = id_trajet;
        this.depart = depart;
        this.destination = destination;
        this.nb_place = nb_place;
        this.prix = prix;
    }

   

    @Override
    public String toString() {
        return "trajet{" + "id_trajet=" + id_trajet + ", depart=" + depart + ", destination=" + destination + ", nb_place=" + nb_place + ", prix=" + prix + '}';
    }

    public int getId_trajet() {
        return id_trajet;
    }

    public String getDepart() {
        return depart;
    }

    public String getDestination() {
        return destination;
    }

    public int getNb_place() {
        return nb_place;
    }

    public float getPrix() {
        return prix;
    }

    public void setId_trajet(int id_trajet) {
        this.id_trajet = id_trajet;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    
    
}

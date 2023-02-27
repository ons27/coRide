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
    private String type;

    public trajet(String depart, String destination, String type) {
        this.depart = depart;
        this.destination = destination;
        this.type = type;
    }

    public trajet(String depart, String destination) {
        this.depart = depart;
        this.destination = destination;
    }

    public trajet(int id_trajet, String depart, String destination, String type) {
        this.id_trajet = id_trajet;
        this.depart = depart;
        this.destination = destination;
        this.type = type;
    }
    
    

    @Override
    public String toString() {
        return "trajet{" + "depart=" + depart + ", destination=" + destination + ", type=" + type + '}';
    }

    public String getDepart() {
        return depart;
    }

    public String getDestination() {
        return destination;
    }

    public String getType() {
        return type;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setType(String type) {
        this.type = type;
    }
      public void setId_trajet(int id_trajet) {
        this.id_trajet = id_trajet;
    }

    public int getId_trajet() {
        return id_trajet;
    }

  
    
    
}

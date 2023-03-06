package entity;

import java.util.Date;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Postes {
	
	  private SimpleIntegerProperty id, id_user, id_trajet, id_vehicule;
	  private SimpleFloatProperty prix;
	  private SimpleStringProperty depart,arrive;
	  
	  public Postes() {}
	  
	  

	  public Postes(int id, int id_user,int id_trajet,int id_vehicule, float prix, String depart, String arrive) {
		this.id =new SimpleIntegerProperty(id);
		this.id_user =new SimpleIntegerProperty(id_user);
		this.id_trajet =new SimpleIntegerProperty(id_trajet);
		this.id_vehicule =new SimpleIntegerProperty(id_vehicule);
		this.prix =new SimpleFloatProperty(prix);
		this.depart =new SimpleStringProperty(depart);
		this.arrive = new SimpleStringProperty(arrive);
	}


	public Postes(int id_user,int id_trajet, int id_vehicule, float prix, String depart, String arrive) {
		    this.id_user =new SimpleIntegerProperty(id_user);
			this.id_trajet =new SimpleIntegerProperty(id_trajet);
			this.id_vehicule =new SimpleIntegerProperty(id_vehicule);
			this.prix =new SimpleFloatProperty(prix);
			this.depart =new SimpleStringProperty(depart);
			this.arrive = new SimpleStringProperty(arrive);
		}
	
	public Postes(int id_trajet, int id_vehicule, float prix, String depart, String arrive) {
		this.id_trajet =new SimpleIntegerProperty(id_trajet);
		this.id_vehicule =new SimpleIntegerProperty(id_vehicule);
		this.prix =new SimpleFloatProperty(prix);
		this.depart =new SimpleStringProperty(depart);
		this.arrive = new SimpleStringProperty(arrive);
	}

	public int getId() {
		return id.get();
	}
	public void setId(int id) {
		this.id = new SimpleIntegerProperty(id);
	}
	public int getId_user() {
		return id_user.get();
	}
	public void setId_user(int id_user) {
		this.id_user = new SimpleIntegerProperty(id_user);
	}
	public int getId_trajet() {
		return id_trajet.get();
	}
	public void setId_trajet(int id_trajet) {
		this.id_trajet = new SimpleIntegerProperty(id_trajet);
	}
	public int getId_vehicule() {
		return id_vehicule.get();
	}
	public void setId_vehicule(int id_vehicule) {
		this.id_vehicule = new SimpleIntegerProperty(id_vehicule);
	}
	public float getPrix() {
		return prix.get();
	}
	public void setPrix(float prix) {
		this.prix = new SimpleFloatProperty(prix);
	}
	public String getDepart() {
		return depart.get();
	}
	public void setDepart(String depart) {
		this.depart = new SimpleStringProperty(depart);
	}
	public String getArrive() {
		return arrive.get();
	}
	public void setArrive(String arrive) {
		this.arrive = new SimpleStringProperty(arrive);
	}



	@Override
	public String toString() {
		return "Postes [id=" + id + ", id_user=" + id_user + ", id_trajet=" + id_trajet + ", id_vehicule=" + id_vehicule
				+ ", prix=" + prix + ", depart=" + depart + ", arrive=" + arrive + "]";
	}

	  
	  
	  
}

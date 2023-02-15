/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package connexionbd;

//import connexionbd.util.DataSource;
import entity.trajet;
import service.trajetservice;

/**
 *
 * @author MSI
 */
public class ConnexionBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        trajet t = new trajet(1, "tunis", "aryana",2,20.2f);
        trajetservice ts=new trajetservice();
//     ts.insert(t);
//        ts.delete(t);
ts.update(t);
        
        
    }
    
}

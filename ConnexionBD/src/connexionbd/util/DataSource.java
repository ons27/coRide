/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connexionbd.util;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MSI
 */
public class DataSource {
    
    private String url="jdbc:mysql://localhost:3306/coride";
    private String login="root";
    private String pwd="";
    private Connection cnx;
    private static DataSource instance ;

   

private DataSource(){
    
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
            System.out.println("connection etablis");
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }

}



public static DataSource getInstance(){


        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }

   
     public Connection getCnx() {
        return cnx;
    }

    

}
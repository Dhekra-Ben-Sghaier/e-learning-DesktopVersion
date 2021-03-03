/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class connexion {
    private String url="jdbc:mysql://127.0.0.1:3306/esprit";
    private String login="root";
    private String pwd="";
    private Connection cnx;
    private static connexion instance;

    public Connection getCnx() {
        return cnx;
    }
    
    
    private connexion() {
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public static connexion getInstance(){
       
       if(instance==null)
           instance=new connexion();
       return instance;
   }
    
    
    
}

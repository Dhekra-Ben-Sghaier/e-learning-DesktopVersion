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
 * @author benha
 */
public class ConnexionSingleton {
     private String url="jdbc:mysql://127.0.0.1:3306/esprit";
    private String login="root";
    private String pwd="";
    private static Connection cnx;
    private static ConnexionSingleton instance;
    
      public static Connection getCnx() {
        return cnx;
    }
        private ConnexionSingleton() {
        try {
            cnx=DriverManager.getConnection(url, login, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(ConnexionSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
         public static ConnexionSingleton getInstance(){
       
       if(instance==null)
           instance=new ConnexionSingleton();
       return instance;
   }
}

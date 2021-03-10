/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author skander
 */
public class DataSource {
  private String url="jdbc:mysql://127.0.0.1/id16271364_brainovation";
  private String login="root";
  private String pwd="";
  static DataSource instance;
  
  private Connection cnx;
  public static DataSource getInstance(){
        if(instance==null){
            instance = new DataSource();
        }
        return instance;
    }
  
  public DataSource(){
      try {
          cnx=DriverManager.getConnection(url, login, pwd);
          System.out.println("connexion etablie");
      } catch (SQLException ex) {
          Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
      }
      
  }
  public Connection getConnection() {
        return cnx;
    }
} 

